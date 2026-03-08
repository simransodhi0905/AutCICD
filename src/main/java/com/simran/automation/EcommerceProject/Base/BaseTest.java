package com.simran.automation.EcommerceProject.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.simran.automation.EcommerceProject.TestUtil.MyWebDriverListener;
import com.simran.automation.EcommerceProject.TestUtil.TestUtil;
import com.simran.automation.EcommerceProject.pageobjects.LandingPage;
import com.simran.automation.EcommerceProject.pageobjects.ProductCatalogue;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public static WebDriver driver;
	public static Properties properties;
    private final String propertyFilePath = "src/main/java/com/simran/automation/EcommerceProject/Config/config.properties"; // Update the path as needed
	public LandingPage landingPage ;
	public ProductCatalogue productCatalogue;
    
	public BaseTest() {
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)) {
            properties = new Properties();
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
		
	}
	
	public static void  initialization() {
        String browserName = properties.getProperty("browser");
        String url = properties.getProperty("url");
        if (browserName.equals("chrome") ) {
        	
        	WebDriverManager.chromedriver().setup();

        		driver= new ChromeDriver();
        		}
        
        	
        else if(browserName.equals("firefox"))
        {//firefox
        }
        
        else throw new RuntimeException("browser not specified in the config.properties file.");
        
     // Create an instance of the event listener
        MyWebDriverListener eventListener = new MyWebDriverListener();

        // Wrap the WebDriver instance with the EventFiringDecorator to listen to events
        WebDriver decoratedDriver = new EventFiringDecorator<>(eventListener).decorate(driver);
        driver = decoratedDriver;

    
	   driver.manage().window().maximize();
	   driver.get(url);
	   driver.manage().deleteAllCookies();
	
	   
   }
	
	@BeforeMethod
	public void launchApplication() {
		initialization();
		landingPage=new LandingPage();
		landingPage.goTo();
		//return landingPage;

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
  
	

}
