package com.simran.automation.EcommerceProject.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.simran.automation.EcommerceProject.Base.BaseTest;



public class ConfirmationPage extends BaseTest{

	
	

	public ConfirmationPage() {

		PageFactory.initElements(driver, this);
		

	}
	
	@FindBy(css = ".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationMessage()
	{
		CheckoutPage cp = new CheckoutPage();	
		return confirmationMessage.getText();
	}
	
	
}