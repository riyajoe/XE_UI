package com.expleo.xe.testrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(  
	    features = "src/test/java/com/expleo/xe/features", glue="stepdefinition",  monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {

}
