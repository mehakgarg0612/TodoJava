package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaskUpdateDetailsPage {
	
	
	//locators
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	By renderOnProject = By.xpath("//span[text()='Projects']");
	By renderOnMyProjects = By.xpath("//span[text()='My Projects']");
	By dailyMeetingBox = By.xpath("//div[@class='cursor-pointer']");
	By renderOnSearchName = By.xpath("//input[@placeholder='Search by Assigned To']");
	By clickingTaskName = By.xpath("//span[text()='Testing2']");
	By renderOnSlider = By.xpath("//div[@role='slider']");
	By renderOnTaskDescription = By.xpath("//textarea[@class='ant-input css-txh9fw']");
	By alertMsg =By.xpath("//div[@class='ant-message-custom-content ant-message-error']//span[2]");
	//By errorOfProgressLowerLimit = By.xpath("//div[contains(text(),'Progress cannot be lower or equal to 44%')]");
	
	By clickOnHold = By.xpath("//span[text()='ON-HOLD']");
	By reasonInputField = By.xpath("//input[@placeholder='REASON']");
	By renderOnHoldTask = By.xpath("//span[text()='Add Task On Hold']");
	By renderOnCancelButton = By.xpath("//span[text()='Cancel']");
	By renderOnOKButton = By.xpath("//button/span[text()='OK']");
	
	
		
	
	//constructors
	public TaskUpdateDetailsPage(WebDriver driver) {
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
	
	public void clickOnTaskName() {
		wait.until(ExpectedConditions.elementToBeClickable(clickingTaskName)).click();
	}
	
//	public void clickOnSlider() {
//		wait.until(ExpectedConditions.elementToBeClickable(renderOnSlider)).click();
//	}

	
	public WebElement getSlider() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(renderOnSlider));
	}

	
	public void enterTaskDescription(String descriptionDetails) {
		WebElement taskDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(renderOnTaskDescription));
		taskDetails.clear();
		taskDetails.click();
		taskDetails.sendKeys(descriptionDetails);
	}
	
	
	// hold task
	
	public void clickOnHoldTask() {
		wait.until(ExpectedConditions.elementToBeClickable(clickOnHold)).click();
	}
	
	
	public void enterHoldTaskDescription(String holdDescriptionDetails) {
		WebElement holdTaskDetails = wait.until(ExpectedConditions.elementToBeClickable(reasonInputField));
		holdTaskDetails.clear();
		holdTaskDetails.click();
		holdTaskDetails.sendKeys(holdDescriptionDetails);
	}
	
		public void clickOnAddTaskOnHold() {
		wait.until(ExpectedConditions.elementToBeClickable( renderOnHoldTask)).click();
	}
	
	
	public void clickOnCancelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnCancelButton)).click();
	}
	
	public void clickOnOKButton() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnOKButton)).click();
	}
	
//	public String getTaskUpdatedSuccessfully(){
//	
//        return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg)).getText();
//    }
//	
//	public String getErrorOfProgressDescription() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg));
//	     return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg)).getText();
//	}
//	
//	public String getErrorOfProgressLowerLimit() {
//		wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg));
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg)).getText();
//	}

	public String getAlertMessage() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(alertMsg)).getText();
	}
	

	
	
}
