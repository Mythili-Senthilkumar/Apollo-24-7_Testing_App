package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class ApolloProducts_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public ApolloProducts_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

 	public static By apolloproductsclick=By.linkText("Apollo Products");
 	public static By category=By.xpath("//p[text()='Categories']");
 	
    // click Apollo Products
    public void apolloProducts() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(apolloproductsclick)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Apollo Products'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to click on 'Apollo Products'. Error: " + e.getMessage());
        }
    }

    // validate Apollo Products page
    public void validateApolloProducts() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(category));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Apollo Products' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to validate 'Apollo Products' page. Error: " + e.getMessage());
        }
    }
}
