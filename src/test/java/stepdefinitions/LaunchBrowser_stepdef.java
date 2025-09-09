package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LaunchPage;
import setup.Hooks;

public class LaunchBrowser_stepdef {

    WebDriver driver = Hooks.driver;  // Use the driver from 
    ExtentTest extTest=Hooks.extTest;
    LaunchPage launchPage = new LaunchPage(driver, extTest);

    @Given("the user launches the browser with URL of the website")
    public void the_user_launches_the_browser_with_url_of_the_website() {
        // No new browser, just navigate if needed
        if(!driver.getCurrentUrl().equals(LaunchPage.getURL())) {
            driver.get(LaunchPage.getURL());
        }
    }

    @Then("the main page of website validated")
    public void the_main_page_of_website_validated() {
        String expectedResult = "https://www.apollo247.com/";
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
