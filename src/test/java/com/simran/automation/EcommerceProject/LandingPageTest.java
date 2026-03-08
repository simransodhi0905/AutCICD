package com.simran.automation.EcommerceProject;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.simran.automation.EcommerceProject.Base.BaseTest;
import com.simran.automation.EcommerceProject.pageobjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPageTest extends BaseTest {
	
	@Test
	public void login()
	
	 {
		// TODO Auto-generated method stub
		
		//LandingPage landingPage=launchApplication();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
		String expectedProduct ="ZARA COAT 3";
		
		landingPage.login("simran.wahan09@gmail.com","Simran@123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));

	}
	
	@Test
	public LandingPage goTo() {
		
		driver.get("https://rahulshettyacademy.com/client");
		return new LandingPage();

	}
	
	

}
