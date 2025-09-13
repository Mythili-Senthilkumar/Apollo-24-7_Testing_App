package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Launch_Page;
import setup.Hooks;

public class Launch_Step {

    WebDriver driver = Hooks.driver;  // Use the driver from 
    ExtentTest extTest=Hooks.extTest;
    Launch_Page launchPage = new Launch_Page(driver, extTest);

    @Given("the user launches the browser with URL of the website")
    public void the_user_launches_the_browser_with_url_of_the_website() {
        // No new browser, just navigate if needed
        if(!driver.getCurrentUrl().equals(Launch_Page.getURL())) {
            driver.get(Launch_Page.getURL());
        }
    }

    @Then("the main page of website is displayed")
    public void the_main_page_of_website_is_displayed() {
        String expectedResult = "https://www.apollo247.com/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
