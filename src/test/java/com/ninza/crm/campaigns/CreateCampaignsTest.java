package com.ninza.crm.campaigns;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninza.crm.generic.baseutility.BaseClass;
import com.ninza.crm.generic.fileutility.ExcelUtility;
import com.ninza.crm.generic.javautility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.CampaignsPage;
import com.ninza.crm.objectrepository.CreateCampaignsPage;
import com.ninza.crm.objectrepository.HomePage;

/**
 * @author Kishor Kulkarni
 * test class contains create campaign with mandatory fields,with status and with expected date
 */

@Listeners(com.ninza.crm.listeners.ListenersImplementation.class)
public class CreateCampaignsTest extends BaseClass {

	@Test(groups = "Smoke Testing")
	public void createCampaignsWithMandatoryFieldsTest() throws IOException {
		
		HomePage hp=new HomePage(driver);
		hp.getCampaigns().click();
		
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		ExcelUtility eu=new ExcelUtility();
		String CNAME = eu.getDataFromExcel("NinzaCRM", 1, 0);
		String TSIZE = eu.getDataFromExcel("NinzaCRM", 1, 1);
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(CNAME);
		ccp.getTargetSize().sendKeys(TSIZE);
		ccp.getCreateCampaign().click();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitForElement(driver, hp.getCampaignSuccessfullyAdded());
		boolean VERIFY = hp.getCampaignSuccessfullyAdded().isDisplayed();
		
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(VERIFY);
		Reporter.log("Campaign successfully Created with Mandatory Fields", true);
		sf.assertAll();
		
		hp.getCrossButton().click();
	}

	@Test(groups = "Regression Testing",dependsOnMethods = "createCampaignsWithMandatoryFieldsTest")
	public void createCampaignsWithStatusTest() throws IOException {
		
		HomePage hp=new HomePage(driver);
		hp.getCampaigns().click();
		
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		ExcelUtility eu=new ExcelUtility();
		String CNAME = eu.getDataFromExcel("NinzaCRM", 1, 0);
		String TSIZE = eu.getDataFromExcel("NinzaCRM", 1, 1);
		String CSTATUS = eu.getDataFromExcel("NinzaCRM", 1, 2);
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(CNAME);
		ccp.getTargetSize().sendKeys(TSIZE);
		ccp.getCampaignStatus().sendKeys(CSTATUS);
		ccp.getCreateCampaign().click();
		
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitForElement(driver, hp.getCampaignSuccessfullyAdded());
		boolean VERIFY = hp.getCampaignSuccessfullyAdded().isDisplayed();
		
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(VERIFY);
		Reporter.log("Campaign successfully Created with Status", true);
		sf.assertAll();
		
		hp.getCrossButton().click();
		
	}


	@Test(groups = "Regression Testing", dependsOnMethods = "createCampaignsWithStatusTest")
	public void createCampaignsWithExpectedDateTest() throws IOException {
		
		HomePage hp=new HomePage(driver);
		hp.getCampaigns().click();
		
		CampaignsPage cp=new CampaignsPage(driver);
		cp.getCreateCampaign().click();
		
		ExcelUtility eu=new ExcelUtility();
		String CNAME = eu.getDataFromExcel("NinzaCRM", 1, 0);
		String TSIZE = eu.getDataFromExcel("NinzaCRM", 1, 1);
		String CSTATUS = eu.getDataFromExcel("NinzaCRM", 1, 2);
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.getCampaignName().sendKeys(CNAME);
		ccp.getTargetSize().sendKeys(TSIZE);
		ccp.getCampaignStatus().sendKeys(CSTATUS);
		
		JavaUtility ju=new JavaUtility();
		String EDATE = ju.getFutureDate(20);
		ccp.getExpectedCloseDate().sendKeys(EDATE);
		ccp.getCreateCampaign().click();
		
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.waitForElement(driver, hp.getCampaignSuccessfullyAdded());
		boolean VERIFY = hp.getCampaignSuccessfullyAdded().isDisplayed();
		
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(VERIFY);
		Reporter.log("Campaign successfully Created with Date", true);
		sf.assertAll();
		
		hp.getCrossButton().click();

	}
}
