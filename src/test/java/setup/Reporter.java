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

    // Fail reporting → only "FAILED" message + screenshot
    public static void reportFail(WebDriver driver, ExtentTest extTest, String message) {
        try {
            String screenshotPath = takeScreenshot(driver, "FAIL");
            if (screenshotPath != null && !screenshotPath.isEmpty()) {
                extTest.log(Status.FAIL, "FAILED: " + message,
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } else {
                extTest.log(Status.FAIL, "FAILED: " + message + " (Screenshot not available)");
            }
        } catch (Exception e) {
            extTest.log(Status.FAIL, "FAILED: " + message + " (Screenshot capture failed)");
        }
    }

    // Pass reporting → only message (no screenshot)
    public static void reportPass(ExtentTest extTest, String message) {
        extTest.log(Status.PASS, message);
    }

    // Generic report → decide based on status
    public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
        if (status == Status.PASS) {
            reportPass(extTest, stepMessage);
        } else if (status == Status.FAIL) {
            reportFail(driver, extTest, stepMessage);
        }
    }

    // Screenshot helper
    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        String screenshotPath = "";
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Folder creation
            String folder = "screenshots";
            File destFolder = new File(folder);
            if (!destFolder.exists()) {
                destFolder.mkdirs();
            }

            // Safe filename
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String safeName = screenshotName.replaceAll("[^a-zA-Z0-9_-]", "_");
            screenshotPath = folder + File.separator + safeName + "_" + timestamp + ".png";

            File dest = new File(screenshotPath);
            FileUtils.copyFile(src, dest);

        } catch (IOException e) {
            System.out.println("Screenshot capture failed: " + e.getMessage());
        }
        return screenshotPath;
    }
}
