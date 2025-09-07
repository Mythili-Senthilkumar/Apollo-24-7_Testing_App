package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import objectRepository.Locators;
import setup.Reporter;

public class LoginPage {

	public WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public LoginPage(WebDriver driver, ExtentTest extTest)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest=extTest;
	}
	
	public void clickloginbutton() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.elementToBeClickable(Locators.login)).click();
	}

	
	public void entermobilenumber(String number) {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield)).sendKeys(number);
	}
	
	public void clickcontinuebutton() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebutton)).click();
	}	
	
	public boolean validateOtpPage() {
		try {
			
		//explicit wait for products element visibility
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Enter OTP']")));
		
		//pass the test in Extent Report
		Reporter.generateReport(driver,extTest,Status.PASS,"Login");
		return true;
		}
		catch(TimeoutException te)
		{
			//fail the test in Extent Report
			Reporter.generateReport(driver,extTest,Status.FAIL,"Login");
			return false;
		}
		
	}
	
	public void enterOtp(String otp) {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.otpfield)).sendKeys(otp);
	    driver.findElement(Locators.verifybutton).click();
	}

	public void validateOtpResult() {
	    try {
	        // Check if error message appears
	        String errorText = wait.until(
	            ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SignIn_errorText__iIxpb"))
	        ).getText();

	        if (errorText.contains("Incorrect OTP")) {
	            Reporter.generateReport(driver, extTest, Status.FAIL, "OTP verification failed: " + errorText);
	            throw new AssertionError("OTP verification failed: " + errorText);
	        }
	    } catch (TimeoutException e) {
	        // No error → assume OTP correct
	        Reporter.generateReport(driver, extTest, Status.PASS, "OTP verified successfully");
	    }
	}

 
	public boolean validateProfilePage() {
		try {
			
			//explicit wait for products element visibility
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPopup")));
			
			//pass the test in Extent Report
			Reporter.generateReport(driver,extTest,Status.PASS,"Profile validation ");
			return true;
			}
			catch(TimeoutException te)
			{
				//fail the test in Extent Report
				Reporter.generateReport(driver,extTest,Status.FAIL,"Profile validation");
				return false;
			}
	}
	
}
