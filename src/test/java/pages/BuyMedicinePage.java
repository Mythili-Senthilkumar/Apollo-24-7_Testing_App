package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.Locators;

public class BuyMedicinePage {

	public WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public BuyMedicinePage(WebDriver driver, ExtentTest extTest)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest=extTest;
	}
	
	//click buy medicine
	public void buyMedicine() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.buymedicineclick)).click();
	}
	
	public void validateBuyMedicine() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Apollo Products']")));
	}
}
