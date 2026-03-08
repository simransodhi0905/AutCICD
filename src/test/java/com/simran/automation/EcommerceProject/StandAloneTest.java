package com.simran.automation.EcommerceProject;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));


		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
		
		String expectedProduct ="ZARA COAT 3";
		
		driver.findElement(By.id("userEmail")).sendKeys("simran.wahan09@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Simran@123");
		driver.findElement(By.id("login")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='card-body']")));

		List<WebElement> products = driver.findElements(By.xpath("//div[@class='card-body']"));
	  //  List<String> itemname= products.stream().map(WebElement::getText).filter(item->item.contains("ZARA")).collect(Collectors.toList());
	  //  itemname.forEach(a -> System.out.println(a));
		
		
		WebElement selectProduct = products.stream().filter(item->item.findElement(By.xpath("./h5/b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		System.out.println(selectProduct.getText());
		selectProduct.findElement(By.xpath("./button[2]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List<WebElement> cartItems=driver.findElements(By.xpath("//div[@class='cartSection']/h3"));
		boolean match=cartItems.stream().anyMatch(item->item.getText().contains("ZARA"));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		driver.findElement(By.xpath("//section[contains(@class,'ta-results')]/button[2]")).click();
		driver.findElement(By.xpath("//a[@class='btnn action__submit ng-star-inserted']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Thankyou')]")));
		String str=driver.findElement(By.xpath("//h1[contains(text(),'Thankyou')]")).getText();
		System.out.println(str);
		Assert.assertTrue(str.equals("THANKYOU FOR THE ORDER."));
		driver.quit();

	}

}
