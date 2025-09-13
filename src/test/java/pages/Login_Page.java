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

import setup.Reporter;

public class Login_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;
    
    public Login_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

  	public static By login=By.xpath("//span[text()='Login']");
  	public static By mobilenumberfield=By.xpath("//input[@name='mobileNumber']");
  	public static By continuebutton=By.xpath("//button[text()='Continue']");
  	public static By otpfield=By.xpath("//input[@title='Please enter the otp']");
  	public static By resendOtpButton = By.xpath("//span[text()='Resend OTP']");
  	public static By verifybutton=By.xpath("//button[text()='Verify']");
  	public static By logoutbutton=By.xpath("//span[@class='ProfileNew_leftBx__mRY1M']");
  	public static By crossclick=By.cssSelector("span[aria-label='close button']");
  	
    
    //navigate to home page
    public void navigateToHomePage() {
        driver.get(pages.Launch_Page.getURL());
    }

    
    // click login button
    public void clickLoginButton() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement popup = shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.Lb")));
            if (popup.isDisplayed()) {
                WebElement closeBtn = driver.findElement(By.cssSelector("span[aria-label='close button']"));
                closeBtn.click();
            }
        } catch (TimeoutException e) {
            // no popup appeared
        }

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Login']")));
        loginBtn.click();
    }

   
    
    // enter invalid mobile number
    public void enterInvalidMobileNumber(String number) {
        WebElement phonefield = wait.until(ExpectedConditions.visibilityOfElementLocated(mobilenumberfield));
        phonefield.clear();
        phonefield.sendKeys(number);
    }
    
    // click cross to cancel
    public void crossClick() {
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(crossclick));
        closeBtn.click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Close button");
    }


    public boolean continueButtonDisabled() {
        try {
            WebElement continueBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(continuebutton)
            );
            boolean disabled = !continueBtn.isEnabled();
            extTest.info("Continue button state (disabled expected): " + disabled);
            return disabled;
        } catch (Exception e) {
            extTest.fail("Could not validate continue button: " + e.getMessage());
            throw e;
        }
    }

    
    // enter valid mobile number
    public void enterMobileNumber(String number) {
        WebElement phonefield = wait.until(ExpectedConditions.visibilityOfElementLocated(mobilenumberfield));
        phonefield.clear();
        phonefield.sendKeys(number);
    }
    
    // click continue button
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continuebutton)).click();
    }   
    
    // logout
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutbutton)).click();
    }
    
    // validate OTP page
    public boolean validateOtpPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Enter OTP']")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Login");
            return true;
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Login");
            return false;
        }
    }
    
 // Enter OTP with timeout check
    public void enterOtp(String otp) {
        try {
            // Wait up to 45 seconds for the OTP field to be visible
            WebElement otpField = new WebDriverWait(driver, Duration.ofSeconds(45))
                    .until(ExpectedConditions.visibilityOfElementLocated(otpfield));

            // Enter the OTP
            otpField.clear();  // clears any existing text
            otpField.sendKeys(otp);

            // Click the verify button
            driver.findElement(verifybutton).click();

            // Log success in report
            Reporter.generateReport(driver, extTest, Status.PASS, "Entered OTP and clicked verify within 45 seconds");
        } catch (TimeoutException e) {
            // Log failure if OTP field does not appear in time
            Reporter.generateReport(driver, extTest, Status.FAIL, "OTP field not visible within 45 seconds");
        } catch (Exception e) {
            // Log any unexpected exception
            Reporter.generateReport(driver, extTest, Status.FAIL, "Exception while entering OTP: " + e.getMessage());
        }
    }

        
        public void resendOtp(String otp) {
            try {
                WebElement resendOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(resendOtpButton));
                resendOtpBtn.click();
                Reporter.generateReport(driver, extTest, Status.PASS, "Resend OTP clicked after 45 seconds timeout");
            } catch (Exception ex) {
                Reporter.generateReport(driver, extTest, Status.FAIL, "Resend OTP button not found");
            }
        }
    

    // validate OTP result
    public void validateOtpResult() {
        try {
            String errorText = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".SignIn_errorText__iIxpb"))
            ).getText();

            if (errorText.contains("Incorrect OTP")) {
                Reporter.generateReport(driver, extTest, Status.FAIL, "OTP verification failed: " + errorText);
               
            }
        } catch (TimeoutException e) {
            Reporter.generateReport(driver, extTest, Status.PASS, "OTP verified successfully");
        }
    }
    
    // validate profile page
    public boolean validateProfilePage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginPopup")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Profile validation ");
            return true;
        } catch (TimeoutException te) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Profile validation");
            return false;
        }
    }
}
