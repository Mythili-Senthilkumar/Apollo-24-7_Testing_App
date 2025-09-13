package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import setup.Reporter;

public class Cart_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public Cart_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        // increased a bit for stability; change as needed
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        this.extTest = extTest;
    }

    public static By cartpage = By.xpath("//h2[text()='OFFERS & DISCOUNTS']");
    public static By dropdown = By.xpath("(//span[contains(@class,'icon-ic-down_arrow')])[1]");
    public static By quantity = By.xpath("(//p[contains(@class,'MedicineProductCard_ddQty')])[3]");
    public static By deleteicon = By.xpath("(//div[contains(@class,'MedicineProductCard_deleteIcon')])[1]");

    public void validateCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartpage));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Cart Page' successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to validate 'Cart Page'. Error: " + e.getMessage());
        }
    }

    // Generic click helper with fallbacks
    private boolean clickWithFallback(By locator, String actionDescription) {
        try {
            WebElement el = wait.until(ExpectedConditions.elementToBeClickable(locator));

            try {
                // Try normal click first
                el.click();
            } catch (Exception normalClickEx) {
                // Scroll into view and try Actions click
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", el);
                    new Actions(driver).moveToElement(el).click().perform();
                } catch (Exception actionsEx) {
                    // Final fallback: JS click
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
                }
            }

            Reporter.generateReport(driver, extTest, Status.PASS, actionDescription + " - Clicked successfully");
            return true;
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    actionDescription + " - Failed to click. Error: " + e.getMessage());
            return false;
        }
    }

    public void dropdownClick() {
        clickWithFallback(dropdown, "Clicked 'Dropdown'");
    }

    public void quantityClick() {
        // If you need to change quantity to a specific value, add an additional locator/flow.
        clickWithFallback(quantity, "Clicked 'Quantity'");
    }
}
