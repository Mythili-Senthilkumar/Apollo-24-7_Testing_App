/*package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class Coupon_Page {

	public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public Coupon_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }
    
 	public static By applycoupon = By.xpath("//p[text()='Apply Coupon']");
 	public static By clickapply=By.xpath("(//span[text()='Apply'])[2]");
 	public static By textbox=By.xpath("//input[@placeholder='Enter Coupon Code']");
 	public static By apply=By.xpath("(//span[text()='Apply'])[1]");
 	public static By invalidcouponmsg=By.xpath("//div[text()='Invalid Coupon Code']");	
 	public static By cancelbutton=By.xpath("(//span[text()='Cancel'])");
 	public static By removecoupon=By.xpath("//i[contains(@class,'CouponEngine_closeIco__KVYQX')]");
 	
    public void clickApplyCoupon() {
    	    try {
    	    	  driver.navigate().back();
    	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	        WebElement applyCouponBtn = wait.until(
    	            ExpectedConditions.elementToBeClickable(applycoupon));
    	        applyCouponBtn.click();
    	        extTest.log(Status.PASS, "Clicked on 'Apply Coupon' successfully.");
    	        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
    	    } catch (Exception e) {
    	        extTest.log(Status.FAIL, "Failed to click 'Apply Coupon': " + e.getMessage());
    	        Reporter.takeScreenshot(driver, "apply_coupon_fail");
    	        throw e;
    	    }
    	}
    
    public void validateApplyCoupon() {

    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement validateapplycoupon = wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Apply Coupon']")));
	        validateapplycoupon.click();
	        extTest.log(Status.PASS, "Clicked on 'Apply Coupon verified' successfully.");
	        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to verify'Apply Coupon': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "apply_coupon_fail");
	        throw e;
	    }
    }
    
   
    public void clickApply() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         wait.until(
            ExpectedConditions.elementToBeClickable(clickapply)).click();
        extTest.log(Status.PASS, "Clicked on 'Apply' successfully.");
        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
    } catch (Exception e) {
        extTest.log(Status.FAIL, "Failed to click'Apply': " + e.getMessage());
        Reporter.takeScreenshot(driver, "apply_coupon_fail");
        throw e;
    }
    }

    
    public void verifyAppliedCoupon() {
     	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement verifyapplied= wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='saved']")));
	        verifyapplied.click();
	        extTest.log(Status.PASS, "Coupon applied successfully.");
	        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to 'Apply Coupon': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "apply_coupon_fail");
	        throw e;
	    }
    }
    
    public void removeCoupon() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(
	            ExpectedConditions.elementToBeClickable(removecoupon)).click();
	        extTest.log(Status.PASS, "Coupon removed successfully.");
	        Reporter.takeScreenshot(driver, "remove_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to 'Remove Coupon': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "remove_coupon_fail");
	        throw e;
	    }
    }
    
    public void validateRemovedCoupon() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement verifyremove= wait.until(
	            ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Apply Coupon']")));
	        //verifyremove.click();
	        extTest.log(Status.PASS, "Coupon applied successfully.");
	        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to 'Apply Coupon': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "apply_coupon_fail");
	        throw e;
	    }
    }
    
    public void enterCouponCode() {
    	
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement couponcode= wait.until(
	            ExpectedConditions.visibilityOfElementLocated(textbox));
	        couponcode.sendKeys("123");
	        extTest.log(Status.PASS, "Coupon coded successfully.");
	        Reporter.takeScreenshot(driver, "code_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to 'Code Coupon': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "code_coupon_fail");
	        throw e;
	    }
    }
    
    public void validateCouponCode() {
    	
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement invalidcode= wait.until(
	            ExpectedConditions.visibilityOfElementLocated(invalidcouponmsg));
	      
	        extTest.log(Status.PASS, "Invalid coupon message sent succesfulyy");
	        Reporter.takeScreenshot(driver, "code_coupon_message");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Invalid coupon message sent failed': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "code_coupon_message");
	        throw e;
	    }
    }
    
    public void applyCodeClick() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement applyclick= wait.until(
	            ExpectedConditions.elementToBeClickable(apply));
	        applyclick.click();
	        extTest.log(Status.PASS, "Clicked on 'Apply' successfully.");
	        Reporter.takeScreenshot(driver, "apply_coupon_clicked");
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to click'Apply': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "apply_coupon_fail");
	        throw e;
	    }
    }
    
    public void cancelClick() {
    	try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement cancelclick= wait.until(
	            ExpectedConditions.elementToBeClickable(cancelbutton));
	        cancelclick.click();
	        extTest.log(Status.PASS, "Clicked on 'Cancel' successfully.");
	        Reporter.takeScreenshot(driver, "cancel_coupon_clicked");
	       
	    } catch (Exception e) {
	        extTest.log(Status.FAIL, "Failed to click 'Cancel': " + e.getMessage());
	        Reporter.takeScreenshot(driver, "cancel_coupon_fail");
	        throw e;
	    }
    }
    
    
 }*/

