package com.simran.automation.EcommerceProject.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simran.automation.EcommerceProject.Base.BaseTest;

public class LandingPage extends BaseTest {

	
	public LandingPage() {
		
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	

	
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");

	}
	
	public ProductCatalogue login(String email,String pwd) {
	username.sendKeys(email);
	password.sendKeys(pwd);
	loginButton.click();
	return new ProductCatalogue();
	}

}
