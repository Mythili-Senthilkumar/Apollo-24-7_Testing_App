package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import objectRepository.Locators;

public class ApolloProductsPage {

	public WebDriver driver;
	WebDriverWait wait;
	ExtentTest extTest;
	
	public ApolloProductsPage(WebDriver driver, ExtentTest extTest)
	{
		this.driver=driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		this.extTest=extTest;
	}
	
	public void apolloProducts() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.apolloproductsclick)).click();
	}

	public void validateApolloProducts() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Categories']")));
	}
}
