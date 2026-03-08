package com.simran.automation.EcommerceProject.TestUtil;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyWebDriverListener implements WebDriverListener {

	 @Override
	    public void beforeClick(WebElement element){
	        System.out.println("Before Clicking on the element :"+element.toString());
	    }
	    @Override
	    public void afterClick(WebElement element){
	        System.out.println("After clicking on the element the element is "+element.toString());
	    }
	    @Override
	    public void beforeFindElement(WebDriver driver , By locator){
	        System.out.println("Before finding the element "+locator.toString());

	    }
	    @Override
	    public void afterFindElement(WebDriver driver , By locator,WebElement result){
	        System.out.println("After finding the element "+locator.toString());
	    }
	    public void beforeNavigateTo(String url,WebDriver driver){
	        System.out.println("Before Clicking on the url"+url);
	    }
	    public void  afterNavigateTo(String url,WebDriver driver ){
	        System.out.println("After Clicking on the url"+url);
	    }
	    public void onError(WebDriver driver,Throwable throwable){
	        System.out.println("Exception occured"+throwable);
	    }
	    
}

