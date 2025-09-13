package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class Profile_Page {

	  public WebDriver driver;
	    WebDriverWait wait;
	    ExtentTest extTest;

	    public Profile_Page(WebDriver driver, ExtentTest extTest) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        this.extTest = extTest;
	  }
	    
	  public static By profile=By.xpath("//a[contains(@class,'Profile_icon__D5bqK')]\"");
	  public static By myorderclick=By.xpath("//a[@href='/orders']//span[contains(text(),'My Orders')]");
	  public static By myorder=By.xpath("//h2[text()=' My Orders']");
	  public static By orderdetails=By.xpath("(//button[normalize-space()='Order Details'])[1]");
	  public static By reorder=By.xpath("//button[span[text()='Re-Order']]");
	  public static By cartpage=By.xpath("//h2[text()='OFFERS & DISCOUNTS']");
	  
	  public void profile() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(profile)).click();
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'Profile'Successfull");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'Profile'. Error: " + e.getMessage());
	        }
	    }
	  public void myorderClick() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(myorderclick)).click();
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'My Order'Successfull");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'My Order'. Error: " + e.getMessage());
	        }
	    }
	  public void myOrder() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(myorder));
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'My Order'Successfull");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'My Order'. Error: " + e.getMessage());
	        }
	    }
	  public void orderDetails() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(orderdetails)).click();
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'Order Details' ");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'Order Details'. Error: " + e.getMessage());
	        }
	    }
	    
	  public void reOrder() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(reorder)).click();
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'Reorder'");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'Reorder'. Error: " + e.getMessage());
	        }
	    }
	  
	  public void cartPage() {
	        try {
	            wait.until(ExpectedConditions.visibilityOfElementLocated(cartpage));
	            Reporter.generateReport(driver, extTest, Status.PASS, "Visibility on 'Cart Page'Successfull");
	        } catch (Exception e) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, 
	                    "Failed  on 'cart Page'. Error: " + e.getMessage());
	        }
	    }
}
