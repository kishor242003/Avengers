package com.ninza.crm.products;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.ninza.crm.generic.baseutility.BaseClass;
import com.ninza.crm.generic.fileutility.ExcelUtility;
import com.ninza.crm.generic.javautility.JavaUtility;
import com.ninza.crm.generic.webdriverutility.WebDriverUtility;
import com.ninza.crm.objectrepository.AddProductPage;
import com.ninza.crm.objectrepository.HomePage;
import com.ninza.crm.objectrepository.ProductsPage;

/**
 * @author Kishor Kulkarni
 * test class contains Add Products with mandatory fields
 */

@Listeners(com.ninza.crm.listeners.ListenersImplementation.class)
public class AddProductsTest extends BaseClass {

	@Test(groups = "Regression Testing")
	public void addProductsWithMandatoryFieldstest() throws IOException {

		HomePage hp=new HomePage(driver);
		hp.getProducts().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.getAddProduct().click();
		
		ExcelUtility eu=new ExcelUtility();
		JavaUtility ju=new JavaUtility();
		int randomNo = ju.getRandomNo();
		String PNAME = eu.getDataFromExcel("NinzaCRM", 4, 0);
		String PQUANTITY = eu.getDataFromExcel("NinzaCRM", 4, 1);
		
		AddProductPage app=new AddProductPage(driver);
		app.getProductName().sendKeys(PNAME+randomNo);
		app.getQuantity().sendKeys(PQUANTITY);
		
		WebElement PCATEGORY = app.getProductCategory();
		WebDriverUtility wdu=new WebDriverUtility();
		wdu.select(PCATEGORY, 1);
		
		String PRICE = eu.getDataFromExcel("NinzaCRM", 4, 1);
		app.getPrice().clear();
		app.getPrice().sendKeys(PRICE);
		
		WebElement VID = app.getVendorId();
		wdu.select(VID, 1);
		
		app.getAdd().click();
		
		wdu.waitForElement(driver, hp.getCampaignSuccessfullyAdded());
		boolean VERIFY = hp.getProductSuccessfullyAdded().isDisplayed();
		
		SoftAssert sf=new SoftAssert();
		sf.assertTrue(VERIFY);
		Reporter.log("Product Successfully Added", true);
		sf.assertAll();
		
		hp.getCrossButton().click();

	}
}

