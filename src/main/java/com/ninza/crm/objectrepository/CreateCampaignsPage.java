package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kishor Kulkarni
 * class contains Elements of Create Campaigns Page of Ninza CRM Application
 */
public class CreateCampaignsPage {
	
	WebDriver driver;
	public CreateCampaignsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name = "targetSize")
	private WebElement targetSize;
	
	@FindBy(name = "expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaign;
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}
	
	
}