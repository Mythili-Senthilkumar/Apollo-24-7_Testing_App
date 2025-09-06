package com.stepDefinition;

import java.util.Properties;

import org.testng.Assert;

import com.stepup.BaseSteps;
import com.stepup.PropertyReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Launch_Browser {

	 BaseSteps base = new BaseSteps(); 

    @Given("user launch the browser")
    public void user_launch_the_browser() {
    	 base.launchBrowser();
          
	    
    }

    @When("the user enter the URL of the website")
    public void the_user_enter_the_url_of_the_website() {
    
    	
    }

    @Then("the main page of website should be displayed")
    public void the_main_page_of_website_should_be_displayed() {
    	Properties prop = PropertyReader.getProperty();
        String expectedResult = prop.getProperty("URL"); // URL from properties
        String actualResult = BaseSteps.driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        BaseSteps.driver.quit();
    }
}
