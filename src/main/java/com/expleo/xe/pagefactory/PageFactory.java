package com.expleo.xe.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
 * PageFactory- This is a super class that contains commonly used web element extraction methods 
 * Driver Instances are passed to this class for further execution 
 */

public abstract class  PageFactory{

	protected WebDriver driver;
	
//Constructor initialization 
	
	public PageFactory(WebDriver driver){
		this.driver=driver;
	
		
	}
	
//Class method to find the specified element 
	
	public WebElement findElement(By findElementBy){
	    return driver.findElement(findElementBy);
	        
	}
//Class method to interact with the web element and send values to the text field	
	public void sendValue(By Locator, String Value){
		
			findElement(Locator).sendKeys(Value);
	}
	    
}
