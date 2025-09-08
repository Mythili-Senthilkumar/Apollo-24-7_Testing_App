package setup;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class Reporter {

    public static void reportFail(WebDriver driver, ExtentTest extTest, String message) throws IOException {
        String screenshotPath = takeScreenshot(driver, message);
        extTest.log(Status.FAIL, message,
		        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public static void reportPass(WebDriver driver, ExtentTest extTest, String message) throws IOException {
        String screenshotPath = takeScreenshot(driver, message);
        extTest.log(Status.PASS, message,
		        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }
    
    public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
        if (status == Status.PASS) {
            try {
				reportPass(driver, extTest, stepMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   // calls existing method that captures screenshot
        } else if (status == Status.FAIL) {
            try {
				reportFail(driver, extTest, stepMessage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   // calls existing method that captures screenshot
        }
    }


    private static String takeScreenshot(WebDriver driver, String name) {
        String folderPath = System.getProperty("user.dir") + File.separator + "screenshot" + File.separator;
        new File(folderPath).mkdirs();
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = folderPath + name.replaceAll("[^a-zA-Z0-9]", "_") + "_" + timestamp + ".png";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
