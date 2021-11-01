package com.expleo.xe.testng;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.*;
import com.expleo.xe.configuration.ExtentReporterNG;
import com.expleo.xe.pages.HomePage;

public class ValidateHomePage  {

	

		
	HomePage PageObject;
	
	
	@Test(dataProvider ="sendData")
	public void testHomeObjects(String amount) throws IOException, InterruptedException {
		ExtentReports extent=ExtentReporterNG.getReportObject();
		ExtentTest test =extent.createTest("Currency Converion Checker");

		PageObject= new HomePage();		
		PageObject.homePageNavigation();
		test.log(Status.PASS,"Navigated to URL Passed");
		PageObject.navigateToURL(amount);
		test.log(Status.PASS,"User entered Amount");
		test.log(Status.PASS,"User entered From Currency");
		test.log(Status.PASS,"User entered To Currency");
		test.log(Status.PASS,"User clicks convert");
		test.log(Status.PASS,"Result Verified and Captured");
		extent.flush();
	}
	
	@DataProvider
	public Object[][] sendData() {
		Object[][] data = new Object[5][1];
		data[0][0]="200";
	    data[1][0]="100";
	    data[2][0]="300";
	    data[3][0]="400";
	    data[4][0]="500";
	    return data;
		
	}
}
