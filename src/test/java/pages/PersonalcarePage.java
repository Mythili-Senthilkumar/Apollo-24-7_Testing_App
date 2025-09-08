package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.Locators;

public class PersonalcarePage {
	
		public WebDriver driver;
		WebDriverWait wait;
		ExtentTest extTest;
		
		public PersonalcarePage(WebDriver driver, ExtentTest extTest) {
			this.driver=driver;
			wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			this.extTest=extTest;
		}
		
		public void clickPersonalCare() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.personalcareclick)).click();
		}
		
		public void clickSkinCare() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.skincareclick)).click();
		}
		
		
		
		public void clickProduct() {
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement product = wait.until(ExpectedConditions.elementToBeClickable(Locators.aloeVeraProduct));
		    product.click();
		}

		public void clickAddtoCart() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.addtocartbutton)).click();
		}
		public void clickViewCart() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.viewcartclick)).click();
		}
		public void validateCart() {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='OFFERS & DISCOUNTS']")));
		}
		
	}


