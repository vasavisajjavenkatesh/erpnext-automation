package com.erpNext.base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class base {
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties locators = new Properties();

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		if(driver == null) {
			FileReader file1 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
			FileReader file2 = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\locators.properties");
			config.load(file1);
			locators.load(file2);
		}
		if(config.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().clearDriverCache().setup();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
			driver.get(config.getProperty("erpNextUrl"));
			loginToErpNext();
		}
	}
	public static void loginToErpNext() throws InterruptedException {
		Thread.sleep(9000);
		driver.findElement(By.xpath(locators.getProperty("login_option"))).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath(locators.getProperty("email_field"))).sendKeys("Administrator");
		driver.findElement(By.xpath(locators.getProperty("password_field"))).sendKeys("password");
		driver.findElement(By.xpath(locators.getProperty("loginapp_button"))).click();
		Thread.sleep(5000);

	}

	
		@AfterMethod
		public void teardown() {
			driver.close();
		}
}
