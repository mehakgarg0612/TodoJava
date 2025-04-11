package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHelper {
	
	 	private WebDriver driver;
	    private WebDriverWait wait;

	    public NavigationHelper(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    public void navigateToDailyScrumMeeting() {
	      
	    	By renderOnProject = By.xpath("//span[text()='Projects']");
	    	By renderOnMyProjects = By.xpath("//span[text()='My Projects']");
	    	By dailyMeetingBox = By.xpath("//div[@class='cursor-pointer']");

	    	
	    		wait.until(ExpectedConditions.elementToBeClickable(renderOnProject)).click();
	    		wait.until(ExpectedConditions.elementToBeClickable(renderOnMyProjects)).click();
	    		wait.until(ExpectedConditions.elementToBeClickable(dailyMeetingBox)).click();

}
}