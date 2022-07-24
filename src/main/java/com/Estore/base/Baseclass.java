package com.Estore.base;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass 
{
	public static Properties prop;
	public static WebDriver driver;
		
	//loadConfig method is to load the configuration

@SuppressWarnings("deprecation")

@BeforeClass
public void browserlaunch()
{
	String key = "webdriver.chrome.driver";
	String value = "./driver/chromedriver_103/chromedriver.exe";
	System.setProperty(key, value);
	String url = "http://automationpractice.com/index.php";
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	driver.get(url);
}	

@AfterClass
public void browserclose()
{
	driver.quit();
}
	}

