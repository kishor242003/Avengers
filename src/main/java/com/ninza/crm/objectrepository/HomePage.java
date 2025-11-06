package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kishor Kulkarni
 * class contains Elements of Home Page of Ninza CRM Application
 */
public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaigns;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement products;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profile;
	
	@FindBy(xpath = "//div[@class='Toastify__toast-body']")
	private WebElement campaignSuccessfullyAdded;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement productSuccessfullyAdded;
	
	@FindBy(xpath = "//button[@aria-label='close']")
	private WebElement crossButton;
	
	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logout;
	
	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getCampaignSuccessfullyAdded() {
		return campaignSuccessfullyAdded;
	}

	public WebElement getProductSuccessfullyAdded() {
		return productSuccessfullyAdded;
	}
	
	public WebElement getLogout() {
		return logout;
	}

	public WebElement getCrossButton() {
		return crossButton;
	}
	
	
	


}
