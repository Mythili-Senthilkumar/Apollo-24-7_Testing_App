package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import setup.Reporter;

public class PersonalcarePage {
    
    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;
    
    public PersonalcarePage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }
  
        public void clickpersonalCare() {
            try {
                Actions actions = new Actions(driver);

                // Hover on Personal Care menu
                WebElement personalCare = driver.findElement(Locators.personalcareclick);
                actions.moveToElement(personalCare).perform();

                // Click personal Care
               personalCare.click();
                extTest.pass("Clicked on Skin Care under Personal Care successfully.");
            } catch (Exception e) {
                extTest.fail("Failed to click Skin Care: " + e.getMessage());
                throw e;
            }
        }
    
        // Wait until Skin Care is clickable
        public void skinCare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement skinCare = wait.until(ExpectedConditions
                .elementToBeClickable(Locators.skincareclick));
        skinCare.click();
        }
    
    public void productClick() {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(Locators.aloeVeraProduct)).click();
    }
    
    public void addClick() {
        try {
       	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(Locators.addtocartbutton)).click();
        } catch (TimeoutException e) {
            // fallback JS click if normal click fails
            WebElement element = driver.findElement(Locators.addtocartbutton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void viewCartclick() {
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.elementToBeClickable(Locators.viewcartclick)).click();
    }
    
    public void validateCart() {
    	try {
    		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='OFFERS & DISCOUNTS']")));
            driver.navigate().back();
            driver.navigate().back();
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Personal care Products' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to validate 'Personal Products' page. Error: " + e.getMessage());
        }
  }
    
    public void clickBrandProduct() {
   	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
   	 wait.until(ExpectedConditions.elementToBeClickable(Locators.handwashclick)).click();
   }
   
   public void addclickDisable() {
       try {
    		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
           WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(Locators.addclickdisable));

           if (!addBtn.isEnabled()) {
               Reporter.reportPass(driver, extTest, "Add button is disabled as expected");
           } else {
               Reporter.reportFail(driver, extTest, "Add button is enabled (unexpected)");
           }

           Reporter.takeScreenshot(driver, "skin care");

           // back → confirm navigation
           driver.navigate().back();
           wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.personalcareclick));

       } catch (Exception e) {
           Reporter.reportFail(driver, extTest, "Add button check failed: " + e.getMessage());
           Reporter.takeScreenshot(driver, "skin care");
       }
   }

  

public void validateSkincare() {
   try {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Skin Care']")));
       Reporter.takeScreenshot(driver, "skin care");
       driver.navigate().back();
       Reporter.reportPass(driver, extTest, "Skin Care page validated");
   } catch (TimeoutException e) {
       Reporter.reportFail(driver, extTest, "Skin Care page validation failed");
   }
}
}
    
