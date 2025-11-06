package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kishor Kulkarni
 * class contains Elements of Campaigns page of Ninza CRM Application
 */
public class CampaignsPage {
	
	WebDriver driver;
	public CampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	public WebElement getCreateCampaign() {
		return createCampaign;
	}

}
