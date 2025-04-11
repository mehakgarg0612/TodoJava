package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskUpdateDetails {
	
	
	//locators
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	By renderOnProject = By.xpath("//span[text()='Projects']");
	By renderOnMyProjects = By.xpath("//span[text()='My Projects']");
	By dailyMeetingBox = By.xpath("//div[@class='cursor-pointer']");
	By renderOnSearchName = By.xpath("//input[@placeholder='Search by Assigned To']");
	By clickingTaskName = By.xpath("//span[text()='Selenium']");
	By renderOnSlider = By.xpath("//div[@role='slider']");
	By renderOnTaskDescription = By.xpath("//textarea[@class='ant-input css-txh9fw']");
	By renderOnHoldTask = By.xpath("//input[@placeholder='REASON']");
	By renderOnAddTaskOnHold = By.xpath("//span[text()='Add Task On Hold']");
	By renderOnCancelButton = By.xpath("//span[text()='Cancel']");
	By renderOnOKButton = By.xpath("//span[text()='OK']");
	
	//constructors
	public TaskUpdateDetails(WebDriver driver) {
		this.driver = driver;	
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	//Actions
	
	public void clickOnProject() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnProject)).click();
	}
	
	public void clickOnMyProjects() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnMyProjects)).click();
	}
	
	public void clickOnDailyMeetingBox() {
		wait.until(ExpectedConditions.elementToBeClickable(dailyMeetingBox)).click();
	}
	
	public void clickOnSearchName(String name) {
		WebElement search =  wait.until(ExpectedConditions.visibilityOfElementLocated(renderOnSearchName));
		search.clear();
		search.click();
		search.sendKeys(name);
	}
	
	
	
	
	
				
	
		

}
