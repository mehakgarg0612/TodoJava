package util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    public static String takeScreenshot(WebDriver driver, String testName) {
        if (driver == null) {
            System.out.println("WebDriver is null. Cannot take screenshot.");
            return null;
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = "/ToDoListFramework_01/screenshots" + File.separator + testName + "_" + timestamp + ".png";

        try {
            if (driver instanceof TakesScreenshot) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                File src = ts.getScreenshotAs(OutputType.FILE);
                File dest = new File(screenshotPath);
                FileUtils.copyFile(src, dest);
                return screenshotPath;
            } else {
                System.out.println("Driver does not support taking screenshots.");
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }

        return null;
    }
}
