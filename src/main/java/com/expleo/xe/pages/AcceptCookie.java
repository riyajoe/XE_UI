package com.expleo.xe.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AcceptCookie {
	protected WebDriver driver;

	public AcceptCookie(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		driver.findElement(By.cssSelector("button[class='button__BaseButton-sc-1qpsalo-0 ctapkr']")).click();
		
		
	}

}
