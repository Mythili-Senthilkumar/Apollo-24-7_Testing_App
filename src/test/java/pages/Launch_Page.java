package pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import setup.Property_Reader;
import setup.Reporter;

import java.time.Duration;

public class Launch_Page {

    WebDriver driver;
    static Properties prop;
    ExtentTest extTest;
    WebDriverWait wait;

    public Launch_Page(WebDriver driver, ExtentTest extTest) {
        this.driver = driver;
        this.extTest = extTest;
        this.prop = Property_Reader.getProperty();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static String getURL() {
        return prop.getProperty("URL");
    }

    public void launchApplication() {
        try {
            String url = getURL();
            driver.get(url);

            // wait until page is loaded (title or url check)
            wait.until(ExpectedConditions.urlContains(url));

            Reporter.generateReport(driver, extTest, Status.PASS,
                    "Launched application with URL: " + url);

        } catch (Exception e) {
            Reporter.generateReport(driver, extTest, Status.FAIL,
                    "Failed to launch application. Error: " + e.getMessage());
        }
    }
}
