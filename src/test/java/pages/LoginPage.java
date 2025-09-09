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
    
    public LoginPage(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
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

    // empty mobile field
    public void emptyMobileNumberField() {
        WebElement phonefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
        phonefield.clear();
    }
    
    // enter invalid mobile number
    public void enterInvalidMobileNumber(String number) {
        WebElement phonefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
        phonefield.clear();
        phonefield.sendKeys(number);
    }
    
    // click cross to cancel
    public void crossClick() {
        WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.crossclick));
        closeBtn.click();
        Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on Close button");
    }


    public boolean continueButtonDisabled() {
        try {
            WebElement continueBtn = wait.until(
                ExpectedConditions.visibilityOfElementLocated(Locators.continuebutton)
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
        WebElement phonefield = wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.mobilenumberfield));
        phonefield.clear();
        phonefield.sendKeys(number);
    }
    
    // click continue button
    public void clickContinueButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.continuebutton)).click();
    }   
    
    // logout
    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(Locators.logoutbutton)).click();
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
                    .until(ExpectedConditions.visibilityOfElementLocated(Locators.otpfield));

            // Enter the OTP
            otpField.clear();  // optional, clears any existing text
            otpField.sendKeys(otp);

            // Click the verify button
            driver.findElement(Locators.verifybutton).click();

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
                WebElement resendOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(Locators.resendOtpButton));
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
