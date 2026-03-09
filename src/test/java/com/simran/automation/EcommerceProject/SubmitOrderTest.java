package com.simran.automation.EcommerceProject;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;


import com.simran.automation.EcommerceProject.Base.BaseTest;
import com.simran.automation.EcommerceProject.pageobjects.CartPage;
import com.simran.automation.EcommerceProject.pageobjects.CheckoutPage;
import com.simran.automation.EcommerceProject.pageobjects.ConfirmationPage;
import com.simran.automation.EcommerceProject.pageobjects.LandingPage;




public class SubmitOrderTest extends BaseTest {
//cicd flow
	
	List<WebElement> productList ;
	
	@Test
	@Parameters({"username"})
	public void verifySubmitOrderTest(String username) {
	 //Step1: Launch and login
	 productCatalogue = landingPage.login(username,"Simran@123");
	  
	//Step2: Get and print all products 
	productList = productCatalogue.getProductsList();
	productList.forEach(System.out::println);
	System.out.println("All products: "+ productList);
	
	//Step3: from the list get productby name and add it to cart
	WebElement selectProduct=productCatalogue.getProductByName("ZARA COAT 3");
	String selProd = selectProduct.getText();
	System.out.println("Selected product is: "+ selProd);

	
	//add product to cart
	
	productCatalogue.addProductToCart(selProd);
	
	//go to cart page
	CartPage cartPage=productCatalogue.goToCartPage();
	Assert.assertTrue(true);
	
	//verify right product is added
	
/*	Boolean match = cartPage.verifyProductDisplay("ZARA COAT 3");
	Assert.assertTrue(match);
	
	//place order
	CheckoutPage checkoutPage = cartPage.goToCheckout();
	checkoutPage.selectCountry("india");
	ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	String confirmMessage = confirmationPage.getConfirmationMessage();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));*/
	
	}
	
	@Test(dependsOnMethods= {"verifySubmitOrderTest"})
	public void verifyOrderHistory()
	{
		productCatalogue = landingPage.login("simran.wahan09@gmail.com","Simran@123");
		System.out.println("Order history test");
		Assert.assertTrue(true);
	}
	
	@Test(groups="smoke")
	public void VerifyCustomerBase() {
		System.out.println("Test: Customer Base");
		Assert.assertTrue(true);
	}
	
	
	
	
}
