package com.expleo.xe.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.expleo.xe.configuration.Configure;
import com.expleo.xe.pages.HomeNavBarConvert;

@RunWith(Cucumber.class)
public class StepDefinition extends Configure{
	public WebDriver driver;
	public WebDriverWait wait ;
	public HomeNavBarConvert navObj;
	String endResult;
	 public StepDefinition() throws IOException {
		super();
		navObj=new HomeNavBarConvert(driver);
		// TODO Auto-generated constructor stub
		}

	@Given("^Open web browser$")
	public void open_web_browser() throws IOException {
		    System.out.println("User Opens the browser");
			driver=setupWebDriver();
			driver.manage().deleteAllCookies();
			//log.debug("driver intialised and cookies deleted ");
			}
	
	@When("^Navigates to the specified url$")
    public void navigates_to_the_specified_url() {
	    	System.out.println("Navigates to the mentioned URL");
			driver.manage().window().maximize();
			driver.get("https://www.xe.com/");
			}  
	@Then("^Homepage loads$")
	public void homepage_loads() throws InterruptedException {
	 		System.out.println("Loaded Home Page");
	 		Thread.sleep(1000);
	 		navObj.clickOnCookie();
	 		}

	@Given("^User selects currency converter menu from navigation panel$")
	public void user_selects_currency_converter_menu_from_navigation_panel() throws InterruptedException{
	    	System.out.println("Click On Convert Button from Navigation Panel");
	    	navObj.clickOnConvertMenuBar();
	    	Thread.sleep(1000);
	    	}

	@When("^User enters amount \"([^\"]*)\"$")
	public void user_enters_amount_something(String amount)  {
	    	System.out.println("User Enters The Amount:"+amount);
	        navObj.sendAmount(amount);
	        }
	@And("^User select currency From dropdownlist$")
	public void user_select_currency_from_dropdownlist() throws InterruptedException {
	    System.out.println("Selected the first currency from the drop downlist");
	       navObj.clickOnfromCurrency();
	   		}

	@And("^User select currency to dropdownlist$")
	public void user_select_currency_to_dropdownlist() throws InterruptedException  {
		    System.out.println("Selected the second currency from the drop downlist");
	        navObj.clickOnToCurrency();
	        }
	@And("^User clicks on convert button$")
	public void user_clicks_on_convert_button() throws InterruptedException  {
		    System.out.println("User Clicked on Convert Button");
	       navObj.clickOnConvert();
	       Thread.sleep(1000);
	       }
	@Then("^Result is displayed and validated$")
	public void result_is_displayed_and_validated() {
	        endResult=navObj.fetchResult();
	        System.out.println("Result Obtained"+endResult);
	        boolean actual=endResult.contains("Indian Rupees");
	    	Assert.assertTrue(actual);
	    	driver.close();
	        }


}

