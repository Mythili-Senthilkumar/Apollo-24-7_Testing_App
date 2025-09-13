package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class BuyMedicine_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public BuyMedicine_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

  //for buy medicine
  	public static By buymedicineclick=By.xpath("//a[text()='Buy Medicines']");
  	public static By check=By.xpath("//a[text()='Apollo Products']");
  	
    // click buy medicine
    public void buyMedicine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(buymedicineclick)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Buy Medicine'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to click on 'Buy Medicine' ");
        }
    }

    // validate buy medicine page
    public void validateBuyMedicine() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(check));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Buy Medicine' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to validate 'Buy Medicine' page. Error: " + e.getMessage());
        }
    }
}
