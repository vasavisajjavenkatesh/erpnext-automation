package com.erpNext.testCases;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.erpNext.base.base;


public class customer extends base {
	
	@Test(dataProvider = "newCustomerDetails", dataProviderClass = ExcelDataSupplier.class)
	public static void createNewCustomer(String UserName) throws InterruptedException {
		Thread.sleep(20000);
		driver.findElement(By.xpath(locators.getProperty("Home"))).click();
		Thread.sleep(20000);
		driver.findElement(By.xpath(locators.getProperty("Customer_field"))).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath(locators.getProperty("Add_customer"))).click();
		Thread.sleep(20000);
		
		driver.findElement(By.xpath(locators.getProperty("CustomerName_field"))).sendKeys(UserName);
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.getProperty("Customer_Type"))).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath(locators.getProperty("Customer_group_selection"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.getProperty("Customer_group_Options_commercial"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.getProperty("Territory_field"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.getProperty("Territory_India_Option"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(locators.getProperty("Save_button"))).click();

	}
}
