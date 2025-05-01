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
	        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String screenshotPath = "./screenshots/" + testName + "_" + timestamp + ".png";
	        
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File src = ts.getScreenshotAs(OutputType.FILE);
	            File dest = new File(screenshotPath);
	            FileUtils.copyFile(src, dest);
	        } catch (Exception e) {
	            System.out.println("Failed to capture screenshot: " + e.getMessage());
	        }

	        return screenshotPath;
	 }

}
