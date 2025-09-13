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


public class Address_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public Address_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.extTest = extTest;
    }

    //==== valid part ====
    public static By cartpage = By.xpath("//h2[(text()='OFFERS & DISCOUNTS')]");
    public static By suggestedarea = By.xpath("//h3[contains(text(),'Shiv Colony')]");
    public static By enterdetails = By.xpath("//h2[text()='Enter Address Details']");
    public static By flatnumber = By.xpath("//textarea[@name='address1']");
    public static By savenext = By.xpath("//button[contains(.,'Save & Next')]");
    public static By radiobtn = By.xpath("//input[@id='someone else']");
    public static By other = By.xpath("//span[normalize-space()='other']");
    public static By recipient = By.xpath("//input[@name='recipientName']");
    public static By savebtn = By.xpath("//button[contains(.,'Save Address')]");

    public void textArea() {
        try {
        	driver.navigate().back();
            WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(textfield));
            text.clear();
            text.sendKeys("9874");
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed in 'Text Area' successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Text Area'. Error: " + e.getMessage());
        }
    }

    public void suggestedLocation() {
        try {
           WebElement suggesstedlocation= wait.until(ExpectedConditions.elementToBeClickable(suggestedarea));
           suggesstedlocation.clear();
           suggesstedlocation.click();
           
           Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Suggested Area'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Suggested Area'. Error: " + e.getMessage());
        }
    }

    public void validateEnterDetails() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterdetails));
            Reporter.generateReport(driver, extTest, Status.PASS, "Verified 'Enter Address Details'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to verify 'Enter Address Details'. Error: " + e.getMessage());
        }
    }

    public void flatNumber() {
        try {
        	WebElement flatno= wait.until(ExpectedConditions.visibilityOfElementLocated(flatnumber));
       flatno.clear();
        	flatno.sendKeys("123");
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed in 'Flat number'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Flat number'. Error: " + e.getMessage());
        }
    }

    public void savenext() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(savenext)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Save & Next'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Save & Next'. Error: " + e.getMessage());
        }
    }

    public void radioBtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(radiobtn)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Someone'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Someone'. Error: " + e.getMessage());
        }
    }

    public void otherClick() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(other)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Others'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Others'. Error: " + e.getMessage());
        }
    }

    public void recipient() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(recipient)).sendKeys("Priya");
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed 'Recipient' name");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Recipient'. Error: " + e.getMessage());
        }
    }

    public void savebtn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(savebtn)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Save Address'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Save Address'. Error: " + e.getMessage());
        }
    }

    public void validateCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(cartpage));
            Reporter.generateReport(driver, extTest, Status.PASS, "Verified 'Cart Page'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to verify 'Cart Page'. Error: " + e.getMessage());
        }
    }

    //==== invalid part ====
    public static By changeclick = By.xpath("//span[normalize-space()='Change']");
    public static By newaddressclick = By.xpath("//span[contains(text(),'Add New Address')]");
    public static By deliverto = By.xpath("//h2[text()='Deliver to'][1]");
    public static By textfieldtype = By.xpath("//input[@placeholder='Search for society, locality, pincode...']");
    public static By noresult = By.xpath("//div[text()='No Result found, Try searching for other location']");

    public void changeClick() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(changeclick)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Change'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Change'. Error: " + e.getMessage());
        }
    }

    public void deliverTo() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(deliverto));
            Reporter.generateReport(driver, extTest, Status.PASS, "Verified 'Deliver To' section");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to verify 'Deliver To'. Error: " + e.getMessage());
        }
    }

    public void newaddressClick() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(newaddressclick)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Add New Address'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Add New Address'. Error: " + e.getMessage());
        }
    }

    public void textAreafield() {
        try {
            WebElement pincode=wait.until(ExpectedConditions.visibilityOfElementLocated(textfieldtype));
            pincode.clear();
            pincode.sendKeys("14756548");
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed in 'Text Area' successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Text Area'. Error: " + e.getMessage());
        }
    }

    public void validateNoResult() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(noresult));
            Reporter.generateReport(driver, extTest, Status.PASS, "Verified 'No Result found'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.PASS, "Failed to verify 'No Result found'. Error: " + e.getMessage());
        }
    }

    // invalid flat number
    public static By textfield = By.xpath("//input[@placeholder='Search for society, locality, pincode...']");
    public static By suggarea = By.xpath("//h3[contains(text(),'Shiv Colony')]");
    public static By enterdetail = By.xpath("//h2[text()='Enter Address Details']");
    public static By flatno = By.xpath("//textarea[@name='address1']");
    public static By savenextbtn = By.xpath("//button[contains(.,'Save & Next')]");
    public static By requiredmsg = By.xpath("//span[text()='Minimum 2 characters are required']");

    public void textField() {
        try {
     
            WebElement location=wait.until(ExpectedConditions.visibilityOfElementLocated(textfield));
           location.clear();
           location.sendKeys("9874");
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed in 'Text Area'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Text Area'. Error: " + e.getMessage());
        }
    }

    public void suggLocation() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(suggarea)).click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Suggested Area'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click on 'Suggested Area'. Error: " + e.getMessage());
        }
    }

    public void validateEnterDetailsPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(enterdetail));
            Reporter.generateReport(driver, extTest, Status.PASS, "Verified 'Enter Address Details Page'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to verify 'Enter Address Details Page'. Error: " + e.getMessage());
        }
    }

    public void flatNo() {
        try {
            WebElement flat=wait.until(ExpectedConditions.visibilityOfElementLocated(flatno));
            flat.clear();
            flat.sendKeys("1");
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed in 'Flat number'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type in 'Flat number'. Error: " + e.getMessage());
        }
    }

    public void saveNextBtn() {
        try {
            // Scroll the button into view before clicking
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(savenextbtn));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

            // Now wait until clickable and then click
            wait.until(ExpectedConditions.elementToBeClickable(savenextbtn)).click();

            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on 'Save & Next'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to click on 'Save & Next'. Error: " + e.getMessage());
        }
    }


    public void reqMsg() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(requiredmsg));
            Reporter.generateReport(driver, extTest, Status.PASS, "Found message 'Minimum 2 characters are required'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to find message 'Minimum 2 characters are required'. Error: " + e.getMessage());
        }
    }

    // invalid recipient
    public void recipientName() {
        try {
            WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(recipient));
            name.clear();
            name.sendKeys("@@@@@s");
            
            Reporter.generateReport(driver, extTest, Status.PASS, "Typed invalid 'Recipient'");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to type invalid 'Recipient'. Error: " + e.getMessage());
        }
    }
}