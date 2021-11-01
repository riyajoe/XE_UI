package com.expleo.xe.configuration;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/*
 * This is a base configuration class that deals with dynamic values like browsertype and url at runtime along with driver initialization.
 */


public class Configure {
	public FileInputStream reader;
	public WebDriver driver;
	public Properties details=new Properties();
	public Configure() throws IOException {
		
	}
	
	@SuppressWarnings("deprecation")
//function to setup webdriver and instantiate a new driver instance based on the browsertype 	
//ChromeOptions updated to block pop-ups while test run in the browser.
	public WebDriver setupWebDriver() throws IOException {
	reader=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/expleo/xe/configuration/configuration.properties");	
	details.load(reader);
	String browserType = details.getProperty("browser");
	if(browserType.equals("chrome")) {
		ChromeOptions options  = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	    driver= new ChromeDriver(capabilities);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	else if(browserType.equals("morzilla")) {
		driver=new FirefoxDriver();
	}
	else {
		//driver=null;
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver.exe");
	    driver= new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	return driver;
		
	}

	
//function to return url from properties file
	public String fetchURL() throws IOException
	{
		details.load(reader);
		String Url=details.getProperty("url");
		return Url;
		
	}
	
}
