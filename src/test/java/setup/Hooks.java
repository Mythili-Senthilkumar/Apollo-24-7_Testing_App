package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.LoginPage;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extReport;
    public static ExtentTest extTest;
    public static LoginPage loginPage;

    // This will run before **all scenarios**, only if driver is null
    @Before(order = 0)
    public void setUp(Scenario scenario) {
        if(driver == null) {                                   // Only open browser once
        	
            // Initialize ExtentReports once
            if (extReport == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
                extReport = new ExtentReports();
                extReport.attachReporter(spark);
            }

            // Create test for this scenario 
            extTest = extReport.createTest(scenario.getName());

            // Start browser
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.apollo247.com/");

            // Initialize page objects
            loginPage = new LoginPage(driver, extTest);
        }
        
        else {
            // Browser already opened, just reuse
            driver.get("https://www.apollo247.com/");
            extTest = extReport.createTest(scenario.getName()); // new test node for reporting
        }
    }

    // Close browser **after all scenarios**, not per scenario
    @After(order = 0)
    public void tearDown() {
        // Do NOT quit driver here if you want to reuse across scenarios
        // You can quit driver in a separate hook after all tests
    }

    // hook to flush reports after all tests
    @After(order = 1)
    public void flushReport() {
        if(extReport != null) extReport.flush();
    }
}
