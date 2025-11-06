package com.ninza.crm.generic.baseutility;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ninza.crm.generic.fileutility.PropertyUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.LoginPage;

/**
 * @author Kishor Kulkarni
 * this class contains TestNG Annotations for login,logout and open Close Browser 
 */
public class BaseClass {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	PropertyUtility pu=new PropertyUtility();

	@BeforeSuite(groups = {"Smoke Testing","Regression Testing"})
	public void configBS() {
		Reporter.log("Before suit",true);
	}
	
	@AfterSuite(groups = {"Smoke Testing","Regression Testing"})
	public void configAS() {
		Reporter.log("After suit",true);
	}
	
	@BeforeClass(groups = {"Smoke Testing","Regression Testing"})
	public void configBC() throws IOException {
		
//		String BROWSER = pu.getDataFromPropertiesFile("browser");
		String BROWSER=System.getProperty("browser");
		
		if(BROWSER.equals("chrome")) {
			ChromeOptions options=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			options.setExperimentalOption("prefs",prefs);
			driver=new ChromeDriver(options);
		}
		else if(BROWSER.equals("firefox"))
			driver=new FirefoxDriver();
		else if(BROWSER.equals("edge"))
			driver=new EdgeDriver();
		
		Reporter.log("Launch Browser",true);
		sdriver=driver;
	}
	
	@AfterClass(groups = {"Smoke Testing","Regression Testing"})
	public void configAC() throws IOException {
		driver.quit();
		Reporter.log("Close Browser",true);
	}
	
	@BeforeMethod(groups = {"Smoke Testing","Regression Testing"})
	public void configBm() throws IOException {
		
		LoginPage lp=new LoginPage(driver);
		String URL = pu.getDataFromPropertiesFile("url");
		String USERNAME = pu.getDataFromPropertiesFile("username");
		String PASSWORD = pu.getDataFromPropertiesFile("password");
		lp.loginToApp(URL, USERNAME, PASSWORD);
		Reporter.log("Login",true);
	}
	
	@AfterMethod(groups = {"Smoke Testing","Regression Testing"})
	public void configAM() {
		HomePage hp=new HomePage(driver);
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.actions(driver, hp.getProfile());
		hp.getProfile().click();
		hp.getLogout().click();
		Reporter.log("Logout",true);
	}
}
