package com.expleo.xe.pages;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.expleo.xe.configuration.Configure;
import com.expleo.xe.pages.HomeNavBarConvert;




public class HomePage extends Configure {
public WebDriver driver;
WebDriverWait wait ;
HomeNavBarConvert navObj;
String endResult;
public static Logger log= LogManager.getLogger(HomePage.class.getName());


public HomePage() throws IOException {
		super();
		//DOMConfigurator.configure("log4j.properties");
		// TODO Auto-generated constructor stub
	}

   
	public void homePageNavigation() throws IOException {
    
		driver=setupWebDriver();
		driver.manage().deleteAllCookies();
		//log.debug("driver intialised and cookies deleted ");
	}


	

	public void maximizeBrowser() {
		driver.manage().window().maximize();
		//log.debug("browser maximized ");
		
	}
	
	
	//@Test(dataProvider="sendData")	
	public void navigateToURL(String Amount) throws IOException, InterruptedException {
		//driver=setupWebDriver();
		//driver.manage().deleteAllCookies();
		//String URL1 =fetchURL();
		//driver.get(details.getProperty("url"));
		driver.get("https://www.xe.com/");
		//log.debug("Redirect to www.xe.com ");
		navObj=new HomeNavBarConvert(driver);
		Thread.sleep(1000);
    	navObj.clickOnCookie();
    	//log.debug("Accept Optional Cookies");
    	Thread.sleep(1000);
    	//log.debug("Send the specified amount for conversion");
    	navObj.sendAmount(Amount);
    	//log.debug("Select from Currency ");
    	navObj.clickOnfromCurrency();
    	//log.debug("Select to Currency ");
    	navObj.clickOnToCurrency();
    	//log.debug("Click on convert ");
    	navObj.clickOnConvert();
    	Thread.sleep(1000);
    	boolean popupButton =driver.findElement(By.xpath("//button[contains(@id , 'yie-close-button')]")).isDisplayed();
    	 System.out.println(popupButton);
    	 if(popupButton) {
    		 driver.findElement(By.xpath("//button[contains(@id , 'yie-close-button')]")).click();
    	 }
    	endResult=navObj.fetchResult();
    	boolean actual=endResult.contains("Indian Rupees");
    	Assert.assertTrue(actual);
    	driver.close();
	}
	
	
    
	
}
