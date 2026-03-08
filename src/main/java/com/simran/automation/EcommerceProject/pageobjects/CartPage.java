package com.simran.automation.EcommerceProject.pageobjects;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simran.automation.EcommerceProject.Base.BaseTest;



public class CartPage extends BaseTest {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;

	public CartPage() {
		PageFactory.initElements(driver, this);

	}

	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase("ZARA COAT 3"));
		return match;

	}

	public CheckoutPage goToCheckout() {
		checkoutEle.click();
		return new CheckoutPage();
		

	}

}
