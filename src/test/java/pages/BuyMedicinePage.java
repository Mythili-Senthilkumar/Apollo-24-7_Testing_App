package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import setup.Reporter;

public class BuyMedicinePage {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public BuyMedicinePage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

    // click buy medicine
    public void buyMedicine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.buymedicineclick)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Buy Medicine'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to click on 'Buy Medicine' ");
        }
    }

    // validate buy medicine page
    public void validateBuyMedicine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Apollo Products']")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Buy Medicine' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to validate 'Buy Medicine' page. Error: " + e.getMessage());
        }
    }
}
