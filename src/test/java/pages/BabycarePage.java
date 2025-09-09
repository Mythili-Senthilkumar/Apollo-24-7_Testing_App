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

import objectRepository.Locators;
import setup.Reporter;

public class BabycarePage {

	 public WebDriver driver;
	    WebDriverWait wait;
	    ExtentTest extTest;

	    public BabycarePage(WebDriver driver, ExtentTest extTest) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.extTest = extTest;
	    }

// to add baby care products using dropdown
	    
	    public void babyCareClick() {
	    	        wait.until(ExpectedConditions.elementToBeClickable(Locators.babyproductclick)).click();
	    	}
	    
	    public void babySkinClick() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.babyskincareclick)).click();
	    }
	    
	    //sort method - reuse it
	    
	    public void betterdiscountClick() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.betterdiscountclick)).click();
	    }
	    
	    public void himalayaproductClick() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.himalayaproductclick)).click();
	    }
	    
	    public void packChangeClick() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.packchangeclick)).click();
	    }
	    
	    public void productAddClick() {
	    	 wait.until(ExpectedConditions.elementToBeClickable(Locators.productaddclick)).click();
	    }
	    
	    public void viewcartClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.viewclick)).click();
	    }
	    public void validateBabycarePage() {
	     	try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='2']")));
	            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Baby care products cart' page successfully");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed to validate 'Baby care products cart' page. Error: " + e.getMessage());
	        }
	    }
	    
	    
// for out of stock pop up
	    
	    public void babyFoodClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.babyfoodclick)).click();
	    }
	    public void babyCerealClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.babycearealclick)).click();
	    }
	    public void sortClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.sortclick)).click();
	    }
	    public void lowtohighClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.lowtohighclick)).click();
	    }
	    public void babyProductClick() {
	    	wait.until(ExpectedConditions.elementToBeClickable(Locators.babyproductclick)).click();
	    }
	    public void validateBabyPage() {
	    	try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='1']")));
	            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Baby care products' page successfully");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed to validate 'Baby care products' page. Error: " + e.getMessage());
	        }
	    }
}
