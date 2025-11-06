package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kishor Kulkarni
 * class contains Elements of Add Products page of Ninza CRM Application 
 */
public class AddProductPage {
	
	WebDriver driver;
	public AddProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory") //dropdown
	private WebElement productCategory;
	
	@FindBy(name = "quantity")
	private WebElement quantity;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement add;

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAdd() {
		return add;
	}
	
	
	
	
	
	
	

}
