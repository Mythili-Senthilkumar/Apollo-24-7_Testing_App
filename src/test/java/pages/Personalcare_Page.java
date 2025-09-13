package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Reporter;

public class Personalcare_Page {

    public WebDriver driver;
    WebDriverWait wait;
    ExtentTest extTest;

    public Personalcare_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        this.extTest = extTest;
    }

  	public static By personalcareclick=By.xpath("//span[text()='Personal Care']");
  	public static By skincareclick=By.xpath("//a[text()='Skin Care']");
  	public static By aloeVeraProduct = By.xpath("//img[@alt='Apollo Life Aloe Vera Skin Care Gel, 200 gm (2x100 gm)']");
  	public static By addtocartbutton=By.xpath("//*[@id=\"add to cart banner\"]/div/div/div[2]/span");
  	public static By viewcartclick=By.xpath("//span[text()='View Cart']");
  	public static By handwashclick=By.xpath("//h2[text()='Apollo Pharmacy Premium Aqua Blue Handwash, 500 ml (2x250 ml)']");
  	public static By addclickdisable=By.xpath("//p[contains(text(),'currently unavailable')]");
  	

    // Click Personal Care with JS fallback
    public void clickPersonalCare() {
        try {
            WebElement personalCare = wait.until(ExpectedConditions.presenceOfElementLocated(personalcareclick));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", personalCare);
            new Actions(driver).moveToElement(personalCare).perform();

            try {
                personalCare.click();
            } catch (Exception e) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", personalCare);
            }

            extTest.log(Status.PASS, "Clicked on Personal Care successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Personal Care: " + e.getMessage());
            Reporter.takeScreenshot(driver, "personalcare_fail");
            throw e;
        }
    }

    // Click Skin Care
    public void clickSkinCare() {
        try {
            WebElement skinCare = wait.until(ExpectedConditions.elementToBeClickable(skincareclick));
            skinCare.click();
            extTest.log(Status.PASS, "Clicked on Skin Care successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Skin Care: " + e.getMessage());
            Reporter.takeScreenshot(driver, "skincare_fail");
            throw e;
        }
    }

    // Click specific product (Aloe Vera)
    public void clickProduct() {
        try {
            WebElement product = wait.until(ExpectedConditions.elementToBeClickable(aloeVeraProduct));
            product.click();
            extTest.log(Status.PASS, "Clicked on Aloe Vera product successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click product: " + e.getMessage());
            Reporter.takeScreenshot(driver, "product_click_fail");
            throw e;
        }
    }

    public void clickAddToCart() {
        try {
            // Scroll to product section
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(aloeVeraProduct));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

            // Try Add to Cart
            WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(addtocartbutton));
            addToCart.click();
            System.out.println("Clicked Add to Cart");

        } catch (TimeoutException e) {
            // If Add to Cart not found, fallback to View Cart
            try {
                WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewcartclick));
                viewCart.click();
                System.out.println("Clicked View Cart");
            } catch (Exception ex) {
                throw new RuntimeException("Neither Add to Cart nor View Cart found", ex);
            }
        }
    }


    // View Cart
    public void clickViewCart() {
        try {
         	 wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement viewCart = wait.until(ExpectedConditions.elementToBeClickable(viewcartclick));
            viewCart.click();
            extTest.log(Status.PASS, "Clicked View Cart successfully.");
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click View Cart: " + e.getMessage());
            Reporter.takeScreenshot(driver, "viewcart_fail");
            throw e;
        }
    }

    // Validate Cart page
    public void validateCartPage() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='OFFERS & DISCOUNTS']")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Validated 'Personal Care Products' page successfully");
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to validate 'Personal Care Products' page: " + e.getMessage());
            Reporter.takeScreenshot(driver, "validate_cart_fail");
        } finally {
            driver.navigate().back();
            driver.navigate().back();
        }
    }

    public void brandProduct() {
        try {
            WebElement product = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.refreshed(
                            ExpectedConditions.elementToBeClickable(handwashclick)
                    ));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);

            extTest.log(Status.PASS, "Clicked on Apollo Handwash product successfully.");
            Reporter.takeScreenshot(driver, "handwash_clicked");
            
        } catch (Exception e) {
            extTest.log(Status.FAIL, "Failed to click Apollo Handwash product: " + e.getMessage());
            Reporter.takeScreenshot(driver, "handwash_fail");
            throw e;
        }
    }



    // Check Add button disabled
    public void checkAddButtonDisabled() {
        try {
            WebElement addBtn = wait.until(ExpectedConditions.presenceOfElementLocated(addclickdisable));
            if (!addBtn.isEnabled()) {
                Reporter.reportPass(driver, extTest, "Add button is disabled as expected.");
            } else {
                Reporter.reportFail(driver, extTest, "Add button is enabled unexpectedly.");
            }
            Reporter.takeScreenshot(driver, "add_button_status");
            driver.navigate().back();
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.personalcareclick));
        } catch (Exception e) {
            Reporter.reportFail(driver, extTest, "Add button check failed: " + e.getMessage());
            Reporter.takeScreenshot(driver, "add_button_fail");
        }
    }

   
}
