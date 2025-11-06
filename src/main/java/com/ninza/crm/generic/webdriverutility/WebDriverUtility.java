package com.ninza.crm.generic.webdriverutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Kishor Kulkarni
 * this class contains methods of Synchronization,Select class and Actions Class
 */
public class WebDriverUtility {
	
public void ImplicitWait(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	public void waitForElement(WebDriver driver, WebElement element) {
		
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void select(WebElement element, String text) {
		Select s=new Select(element);
		s.selectByContainsVisibleText(text);
		
	}
	
	public void select(WebElement element, int index) {
		Select s=new Select(element);
		s.selectByIndex(index);

	}
	
	public void actions(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}

}
