package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class Payment_Page {

	public static By proceed=By.xpath("//button//span[contains(text(),'PROCEED')]");
	public static By addplan=By.xpath("//button//span[contains(text(),'Add Plan')]");
	public static By benefitsapplied=By.xpath("//p[contains(text(),'Benefits Applied')]");
	public static By firstproceed=By.xpath("//span[contains(text(),'PROCEED')]");
	public static By deliverytype=By.xpath("//h2[text()='Choose Delivery Type']");
	public static By proceedButton = By.xpath("//button//span[normalize-space()='Proceed']");
	public static By payment=By.xpath("//div[normalize-space(text())='Payments']");
	public static By qrcode=By.xpath("//div[text()='Show QR Code']");
	public static By cancelqr=By.xpath("//span[text()='Cancel Payment']");
	public static By proceedlocation=By.xpath("//button[span[text()='Proceed']]");
	
public WebDriver driver;
WebDriverWait wait;
ExtentTest extTest;

public Payment_Page(WebDriver driver, ExtentTest extTest) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    this.extTest = extTest;
}

public void clickProceed() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(proceed));
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Proceed'");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to click on 'Proceed'. Error: " + e.getMessage());
    }
}

public void addressProceed() {
	try {
        wait.until(ExpectedConditions.elementToBeClickable(proceedlocation));
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Proceed'");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to click on 'Proceed'. Error: " + e.getMessage());
    }
}
public void clickAddPlan() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(addplan));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Add Plan' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Add Plan' page. Error: " + e.getMessage());
    }
}

public void validateBenefitsApplied() {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(benefitsapplied));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Benefits Applied' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Benefits Applied' page. Error: " + e.getMessage());
    }
  }

public void firstProceed() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(firstproceed));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Proceed' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Proceed' page. Error: " + e.getMessage());
    }
  }
public void deliveryType() {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deliverytype));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Delivery Type' page successfully");
    } catch (Exception e) {
    
    	Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Delivery Type' page. Error: " + e.getMessage());
    }
  }
public void secondProceed() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(proceedButton));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Proceed' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Proceed' page. Error: " + e.getMessage());
    }
  }

public void validatePaymentPage() {
    try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(payment));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Payment' page successfully");
        driver.navigate().back();
        driver.navigate().back();
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Payment' page. Error: " + e.getMessage());
    }
  }

public void qrCodePayment() {
	try {
        wait.until(ExpectedConditions.elementToBeClickable(qrcode));
        Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Show QR' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to validate 'Show QR' page. Error: " + e.getMessage());
    }
}

public void cancelQR() {
	try {
        wait.until(ExpectedConditions.elementToBeClickable(cancelqr));
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Cancel' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to click on 'Cancel' page. Error: " + e.getMessage());
    }
}


//invalid payment
public static By skipSavings = By.xpath("//button[span[text()='Skip Savings']]");
public static By paylater=By.xpath("//div[text()='Pay Later']");

public void skipSavings() {
    try {
        wait.until(ExpectedConditions.elementToBeClickable(skipSavings));
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Skip Savings' page successfully");
    } catch (Exception e) {
        Reporter.generateReport(driver, extTest, Status.FAIL, 
                "Failed to click on 'Skip Savings'. Error: " + e.getMessage());
    }
}


public void payLater() {
 try {
	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
     WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(paylater));
     
     // Scroll until element is visible
     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
     
     if (element.isDisplayed() && element.isEnabled()) {
         element.click();
         Reporter.generateReport(driver, extTest, Status.PASS, 
                 "Clicked on 'Pay Later' button successfully");
     } else {
         Reporter.generateReport(driver, extTest, Status.FAIL, 
                 "'Pay Later' button is not clickable");
     }
 } catch (Exception e) {
     Reporter.generateReport(driver, extTest, Status.FAIL, 
             "Failed to validate 'Pay Later' button. Error: " + e.getMessage());
 }
}

}

