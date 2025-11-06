package com.ninza.crm.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Kishor Kulkarni
 * class contains Elements of Products Page of Ninza CRM Application
 */
public class ProductsPage {
	
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProduct;
	
	public WebElement getAddProduct() {
		return addProduct;
	}

}
