package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    
    // Generic safe click with scroll and wait
    private void safeClick(By locator, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(500);  // small pause for animations
            element.click();
            Reporter.generateReport(driver, extTest, Status.PASS, "Clicked on " + elementName);
        } catch (TimeoutException e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Failed to click " + elementName);
        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Exception clicking " + elementName + ": " + e.getMessage());
        }
    }
    
    public void clickPersonalCare() {
        safeClick(Locators.personalcareclick, "Personal Care");
    }
    
    public void clickSkinCare() {
        safeClick(Locators.skincareclick, "Skin Care");
    }
    
    public void clickProduct() {
        safeClick(Locators.aloeVeraProduct, "Aloe Vera product");
    }
    
    public void clickAddtoCart() {
        safeClick(Locators.addtocartbutton, "Add to Cart");
    }
    
    public void clickViewCart() {
        safeClick(Locators.viewcartclick, "View Cart");
    }
    
    public void addProductToCartAndView() {
        clickAddtoCart();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        clickViewCart();
    }
    
    public void clickBrand() {
        safeClick(Locators.brandclick, "Brand");
    }
    
    public void clickPharmacy() {
        safeClick(Locators.apollopharmacyclick, "Apollo Pharmacy");
    }
    
    public void clickBrandProduct() {
        safeClick(Locators.addclick, "Add button in Brand Product");
    }
    
    public void validateCart() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='OFFERS & DISCOUNTS']")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Cart validated successfully");
            driver.navigate().back();
            driver.navigate().back();
        } catch (TimeoutException e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Cart validation failed");
        }
    }
    
    public void validateSkincare() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Skin Care']")));
            Reporter.generateReport(driver, extTest, Status.PASS, "Skin Care page validated");
        } catch (TimeoutException e) {
            Reporter.generateReport(driver, extTest, Status.FAIL, "Skin Care page validation failed");
        }
    }

    public WebElement getBrandElement() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Brands']"))
        );

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        return element;
    }


    public WebElement getBrandProductElement() {
        return driver.findElement(Locators.apollopharmacyclick);
    }

}
