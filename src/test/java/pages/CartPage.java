package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import setup.Reporter;

public class CartPage {
    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;


    public CartPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }
    

    public void cartIcon() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.carticon));
            extTest.log(Status.PASS, "Cart Icon loaded successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Cart Icon not loaded: " + e.getMessage());
        }
    }



    public void validateCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.cartpage));
            extTest.log(Status.PASS, "Cart Page loaded successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Cart Page not loaded: " + e.getMessage());
        }
    }

    
    public void changeQuantity() {
        try {
            WebElement qtyDropdown = wait.until(ExpectedConditions.elementToBeClickable(Locators.dropdown));
            qtyDropdown.click();
            extTest.log(Status.INFO, "Clicked on Quantity dropdown.");

            WebElement qty3 = wait.until(ExpectedConditions.elementToBeClickable(Locators.newquanity));
            qty3.click();
            extTest.log(Status.INFO, "Selected Quantity = 3.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to change quantity: " + e.getMessage());
        }
    }

   
    public void validateUpdatedQuantity() {
        try {
            WebElement qtyElement = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.updatedquantity));
            String qtyText = qtyElement.getText();  // e.g., "Qty 3"

            if (qtyText.contains("3")) {
                extTest.log(Status.PASS, "Quantity updated successfully: " + qtyText);
            } else {
                extTest.log(Status.FAIL, "Quantity not updated. Current: " + qtyText);
            }
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to validate updated quantity: " + e.getMessage());
        }
    }
    
   
        // Method to click delete icon and take screenshot
        public void clickDeleteIcon() {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                
                // Wait until the delete icon is clickable
                WebElement deleteIcon = wait.until(ExpectedConditions.elementToBeClickable(Locators.deleteicon));

                // Click the delete icon
                deleteIcon.click();

                // Take screenshot after deletion
                Reporter.takeScreenshot(driver,"DeleteIconClicked");

            } catch (Exception e) {
                System.out.println("Failed to click delete icon: " + e.getMessage());
            }
        }
    }


