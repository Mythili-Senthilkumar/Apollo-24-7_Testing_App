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

    public static void generateReport(WebDriver driver, ExtentTest extTest, Status status, String stepMessage) {
        if (status.equals(Status.PASS)) {
            System.out.println("***** " + stepMessage + " is passed *****");
            extTest.log(status, stepMessage);
        } else if (status.equals(Status.FAIL)) {
            System.out.println("***** Step Failed: " + stepMessage + " *****");
            String screenshotName = capture(driver, stepMessage);
            extTest.log(status, stepMessage,
			        MediaEntityBuilder.createScreenCaptureFromPath(screenshotName).build());
        }
    }

    public static String capture(WebDriver driver, String errorName) {
        String userDir = System.getProperty("user.dir");
        String folderPath = userDir + "\\screenshot\\";
        new File(folderPath).mkdirs(); // make sure folder exists

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss");
        String time = sdf.format(date);

        String fileName = folderPath + errorName.replaceAll("[^a-zA-Z0-9]", "_") + "_" + time + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File(fileName);

        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileName;
    }
}
