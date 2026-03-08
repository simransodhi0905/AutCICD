package com.simran.automation.EcommerceProject.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simran.automation.EcommerceProject.Base.BaseTest;
import com.simran.automation.EcommerceProject.TestUtil.TestUtil;


public class ProductCatalogue extends BaseTest {
	
	
	@FindBy(xpath="//div[@class='card-body']")
	List<WebElement> products;
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;


	By productsBy = By.xpath("//div[@class='card-body']");
	By toastMessage = By.cssSelector("#toast-container");
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;


	public ProductCatalogue() {
		
		
		PageFactory.initElements(driver,this);
		
		
	}
	
	public List<WebElement> getProductsList() {
		TestUtil.waitForElementToAppear(productsBy);
		return products;
	}
	
	public WebElement getProductByName(String productName) {
		
		WebElement selectProduct = getProductsList().stream().filter(item->item.findElement(By.xpath("./h5/b")).getText().equals(productName)).findFirst().orElse(null);
		return selectProduct;	
	}
	
	public void addProductToCart(String productName) {
		
		TestUtil.waitForElementToAppear(productsBy);
		WebElement prod=getProductByName("ZARA COAT 3");
		prod.findElement(By.xpath("./button[2]")).click();
		TestUtil.waitForElementToAppear(toastMessage);
		TestUtil.waitForWebElementToDisappear(spinner);

	}
	
	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage = new CartPage();
		return cartPage;
	}
	
	

}
