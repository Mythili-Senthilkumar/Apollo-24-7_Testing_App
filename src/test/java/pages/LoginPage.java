package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	// click login button
	public void clickLoginButton() {
	    try {
	        // If popup appears, close it
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
	        WebElement popup = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Lb")));
	        if (popup.isDisplayed()) {
	            WebElement closeBtn = driver.findElement(By.cssSelector("span[aria-label='close button']"));
	            closeBtn.click();
	        }
	    } catch (TimeoutException e) {
	        // No popup appeared, safe to continue
	    }

	    // Now click Login button safely
	    WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Login']")));
	    loginBtn.click();
	}


	// empty mobile field
	public void emptyMobileNumberField() {
		WebElement phonefield=wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
		phonefield.clear();
	}
	
	// enter invalid mobile number
	public void enterInvalidMobileNumber(String number) {
		WebElement phonefield=wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
		phonefield.clear();
		phonefield.sendKeys(number);
	}
	//click cross to cancel
	public void crossClick() {
	    WebElement closeBtn = wait.until(
	    ExpectedConditions.elementToBeClickable(Locators.crossclick));
	    closeBtn.click();
	    Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Close button");
	}


	//validate continue button disabled
	public boolean continueButtonDisabled() {
		WebElement continuebutton=wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.continuebutton));
		boolean disabled=!continuebutton.isEnabled(); 
		
		if(disabled) {
			Reporter.generateReport(driver, extTest, Status.PASS, "Continue button disabled");
		}else {
			Reporter.generateReport(driver, extTest, Status.FAIL, "Continue button enabled");
		}
		return disabled;
	}
	
	
	
	// enter valid mobile number
	public void enterMobileNumber(String number) {
		 //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement phonefield= wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
		 phonefield.clear();
		 phonefield.sendKeys(number);
	}
	
	// click continue button
	public void clickContinueButton() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebutton)).click();
	}	
	
	public void clickLogout() {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(Locators.logoutbutton)).click();
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
