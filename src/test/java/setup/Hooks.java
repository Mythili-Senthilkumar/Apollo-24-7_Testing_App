package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.Address_Page;
import pages.ApolloProducts_Page;
import pages.BuyMedicine_Page;
import pages.Cart_Page;
//import pages.Coupon_Page;
import pages.Login_Page;

import pages.Payment_Page;
import pages.Personalcare_Page;
import pages.Profile_Page;

public class Hooks {

    public static WebDriver driver;
    public static ExtentReports extReport;
    public static ExtentTest extTest;
    
    public static Login_Page loginPage;
    public static BuyMedicine_Page buymedicinePage;
    public static ApolloProducts_Page apolloProductsPage;
   public static Personalcare_Page personalcarePage;

     
       public static Payment_Page paymentPage;
       public static Cart_Page cartPage;
       public static Address_Page addressPage;
       public static Profile_Page profilePage;
       
       
    @Before(order = 0)
    public void setUp(Scenario scenario) {
        try {
            //  Initialize ExtentReports once
            if (extReport == null) {
                ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
                extReport = new ExtentReports();
                extReport.attachReporter(spark);
            }

            // Open browser if not already started
            if (driver == null) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.apollo247.com/");
            }

            // Create new ExtentTest for each scenario
            String testName = scenario.getName();
            if (testName == null || testName.trim().isEmpty()) {
                testName = "Unnamed Scenario";
            }
            extTest = extReport.createTest(testName);

            // Initialize page objects for every scenario
            loginPage = new Login_Page(driver, extTest);
            buymedicinePage = new BuyMedicine_Page(driver, extTest);
            apolloProductsPage = new ApolloProducts_Page(driver, extTest);
            personalcarePage = new Personalcare_Page(driver, extTest);
           
           // couponPage=new Coupon_Page (driver,extTest);
            paymentPage=new Payment_Page(driver,extTest);
            cartPage=new Cart_Page(driver,extTest);
            addressPage=new Address_Page(driver,extTest);
            profilePage=new Profile_Page(driver,extTest);
           

            extTest.info("Browser launched and page objects initialized.");

        } catch (Exception e) {
            if (extTest != null) {
                extTest.fail("Failed during setup: " + e.getMessage());
            }
            throw e;
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                String screenshotPath = Reporter.takeScreenshot(driver, scenario.getName());
                extTest.fail("Scenario failed, screenshot captured.")
                       .addScreenCaptureFromPath(screenshotPath);
            } else {
                extTest.pass("Scenario passed successfully.");
            }
        } catch (Exception e) {
            if (extTest != null) {
                extTest.warning("Could not attach screenshot: " + e.getMessage());
            }
        }
    }

    @After(order = 1)
    public void flushReport() {
        if (extReport != null) {
            extReport.flush();
        }
    }
}
