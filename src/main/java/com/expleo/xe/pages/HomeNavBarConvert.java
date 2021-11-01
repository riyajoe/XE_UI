package com.expleo.xe.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.expleo.xe.pagefactory.PageFactory;

public class HomeNavBarConvert extends PageFactory {
   public By convertObj;
   private By acceptCookie=By.cssSelector("button[class='button__BaseButton-sc-1qpsalo-0 ctapkr']");
   private By amount= By.id("amount");
   private By from = By.id("midmarketFromCurrency");
   private By to = By.id("midmarketToCurrency");
   private By convertButton = By.xpath("//button[text() = 'Convert']");
   private By fromDropDownList = By.xpath("//li[@id =\"midmarketFromCurrency-option-3\"]");
   private By toDropDownList = By.xpath("//li[@id =\"midmarketToCurrency-option-1\"]");
   private By finalResult =By.xpath("//p[contains(@class , 'result')]");
   private By convertOption = By.xpath("//span[text() = 'Convert']//parent::a");

			
	public HomeNavBarConvert(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		
	}

	public void clickOnCookie() {
		findElement(acceptCookie).click();
	}
	
	public void clickOnConvertMenuBar() {
		findElement(convertOption).click();
	}

	public void sendAmount( String Amount) {
		sendValue(amount,Amount);
	}
	
	public void clickOnfromCurrency() throws InterruptedException {
		findElement(from).click();
		Thread.sleep(5000);
		findElement(fromDropDownList).click();
	}
	
	public void clickOnToCurrency() throws InterruptedException {
		findElement(to).click();
		Thread.sleep(5000);
		findElement(toDropDownList).click();
	}
	
	public void clickOnConvert() {
		findElement(convertButton).click();
	}
	
	public String fetchResult() {
		List<WebElement> resultSet = driver.findElements(finalResult);
		String value1=resultSet.get(0).getText();
		String value2=resultSet.get(1).getText();
		System.out.println(value1+value2);
		return (value1+value2);
	}

}
