package com.simran.automation.EcommerceProject.TestUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.simran.automation.EcommerceProject.Base.BaseTest;



public class TestUtil extends BaseTest {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "/Users/simransodhi/eclipse-workspace2/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestUpdated.xlsx";

	static Workbook book;
	static Sheet sheet;
	static JavascriptExecutor js;
	
	
	
	public void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void clickOn(int i,WebElement element) {
		
		new WebDriverWait(driver, Duration.ofSeconds(i)).
		until(ExpectedConditions.elementToBeClickable(element));
        element.click(); 
        
        
	}
	
	public static List sortTexts(List originalList) {
		
		List <String> sortedList = new ArrayList<>(originalList);	
		Collections.sort(sortedList);
		return sortedList;
		
		}
	public static List convertToText(List<WebElement> originalList) {
		
		List<String> texts = originalList.stream().map(WebElement::getText).filter(t->!t.trim().isEmpty()).collect(Collectors.toList());
		return texts;
		
		
	}
	
	public static void waitForElementToAppear(By element)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
	wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}	
	public static void waitForWebElementToAppear(WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
	wait.until(ExpectedConditions.visibilityOf(element));
}
	public static void waitForWebElementToDisappear(WebElement element)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));	
	wait.until(ExpectedConditions.invisibilityOf(element));
}
	
	

}
	
