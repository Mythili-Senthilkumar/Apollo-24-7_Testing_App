package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
  
    
    public void clickPersonalCare() {
    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.personalcareclick)).click();
    }
    
    public void clickSkinCare() {
    	
    wait.until(ExpectedConditions.elementToBeClickable(Locators.skincareclick)).click();
    }
    
    public void productClick() {
    	wait.until(ExpectedConditions.elementToBeClickable(Locators.aloeVeraProduct)).click();
    }
    public void addClick() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(Locators.addtocartbutton)).click();
        } catch (TimeoutException e) {
            // fallback JS click if normal click fails
            WebElement element = driver.findElement(Locators.addtocartbutton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void viewCartclick() {
    	wait.until(ExpectedConditions.elementToBeClickable(Locators.viewcartclick)).click();
    }
    
    public void validateCart() {
    	try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='OFFERS & DISCOUNTS']")));
            driver.navigate().back();
            driver.navigate().back();
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Personal care Products' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, 
                    "Failed to validate 'Personal Products' page. Error: " + e.getMessage());
        }
}
}
    
