package pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import enums.Priority;

public class TaskUpdateDetailsPage {
	
	//locators
	WebDriver driver;
	WebDriverWait wait;
	
	By PROJECTS = By.xpath("//span[text()='Projects']");
	By MY_PROJECTS = By.xpath("//span[text()='My Projects']");
	By QA_SCRUM_MEETING = By.xpath("//div[@class='cursor-pointer']");
	By SEARCH_NAME= By.xpath("//input[@placeholder='Search by Assigned To']");
	By TASK_NAME = By.xpath("//span[text()='Mehaktesting']"); //task name
	By PROGRESS = By.xpath("//div[@role='slider']");
	By PROGRESS_DESCRIPTION = By.xpath("//div//textarea[@class='ant-input css-txh9fw']");
	
	By ALERT_MESSAGE =By.xpath("//div[@class='ant-message-custom-content ant-message-error']//span[2]");
	By ALERT_TASK_UPDATED_SUCCESSFULLY = By.xpath("//div[@class='ant-message-custom-content ant-message-success']//span[2]");
	
	By ALERT_TASK_ON_HOLD = By.xpath("//div[@class='ant-message-custom-content ant-message-success']//span[2]");
	By ALERT_TASK_RESTART = By.xpath("//div[@class='ant-message-custom-content ant-message-success']//span[2]");
	By ALERT_TASK_DELETED = By.xpath("//div[@class='ant-message-custom-content ant-message-success']//span[2]");
	//By errorOfProgressLowerLimit = By.xpath("//div[contains(text(),'Progress cannot be lower or equal to 44%')]");
	
	By ADD_THIS_TASK_ON_HOLD = By.xpath("//span[text()='ON-HOLD']");
	By REASON = By.xpath("//input[@placeholder='REASON']");
	By ADD_TASK_ON_HOLD = By.xpath("//span[text()='Add Task On Hold']");
	
	By RESTART_THIS_TASK = By.xpath("//span[text()='RESTART']");
	By RESTART_TASK = By.xpath("//span[text()='Restart Task']");
	
	By CANCEL = By.xpath("//span[text()='Cancel']");
	By OK= By.xpath("//button/span[text()='OK']");
	
	By TASK_NAME_ERROR = By.xpath("//div[text()='Please enter the Task name']");
	By TASK_DESCRIPTION_ERROR = By.xpath("//div[text()='Please enter the Task description']");
	
	//CRUD OPERATION - (DELETE, UPDATE)
	
	public static Function<String, By> UPDATE_TASK = (taskName) -> 
    By.xpath("//span[text()='" + taskName + "']/ancestor::tr//i[@class='ri-edit-fill']");
    
    By TASK_NAME_UPDATE =  By.xpath("//input[@placeholder='Enter Task Name']");
    By TASK_DESCRIPTION = By.xpath("//textarea[@placeholder='Enter Task Description']");
    By PRIORITY = By.xpath("//input[@id='priority']");
    By UPDATE = By.xpath("//span[text()='UPDATE']");
    //By CANCEL = By.xpath("//span[text()='Cancel']");

    
    //Delete task
	public static Function<String, By> DELETE_TASK = (taskName) ->
    By.xpath("//div[@class='ant-table-content']//tbody//tr[.//span[text()='" + taskName + "']]//td[8]//button//i[@class='ri-delete-bin-6-fill']");
	
	//div[@class='ant-table-content']//tbody//tr[.//span[text()='Selenium']]//td[8]//button//i[@class='ri-delete-bin-6-fill']
	
	
	//constructors
	public TaskUpdateDetailsPage(WebDriver driver) {
		this.driver = driver;	
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	
	//Actions
	
	
	public String getTaskNameError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_NAME_ERROR)).getText();
	}
	
	public String getTaskDescriptionError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_DESCRIPTION_ERROR)).getText();
	}
	//CRUD ACTION  ---> UPDATE TASK
	
	
	public void clickOnUpdateTask(String taskName) {
		driver.findElement(UPDATE_TASK.apply(taskName)).click();
	}
	 
	//reusuable method for alert message(ALERT_TASK_UPDATED_SUCCESSFULLY)
	
	public void enterUpdateTaskName(String UpdatedTaskName) {
	WebElement UpdateTaskName =wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_NAME_UPDATE));
	
	UpdateTaskName.click(); 
	UpdateTaskName.sendKeys(Keys.CONTROL + "a"); 
	UpdateTaskName.sendKeys(Keys.DELETE);        
	UpdateTaskName.sendKeys(UpdatedTaskName); 
    
//	UpdateTaskName.clear();
//	UpdateTaskName.click();
//	UpdateTaskName.sendKeys(UpdatedTaskName);
    }
		
	public void enterUpdateTaskDescription(String UpdatedTaskDescription) {
	WebElement UpdateDescription=wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_DESCRIPTION));
	
	 UpdateDescription.click(); 
	 UpdateDescription.sendKeys(Keys.CONTROL + "a"); 
	 UpdateDescription.sendKeys(Keys.DELETE);        
	 UpdateDescription.sendKeys(UpdatedTaskDescription); 
    
//	UpdateDescription.clear();
//	UpdateDescription.click();
//	UpdateDescription.sendKeys(UpdatedTaskDescription);
    }
	
	public void selectPriority(Priority priority) {
		}
	
	public void clickOnUpdate() {
		wait.until(ExpectedConditions.elementToBeClickable(UPDATE)).click();
	}
	
	
	
	// DELETE TASK
	public void clickOnDeleteTask(String taskName) {
		driver.findElement(DELETE_TASK.apply(taskName)).click();}
	
	
	public String getTaskDeletedSuccessfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_DELETED)).getText();}
	
	
	//TASK CREATION
	public void clickOnProject() {
		wait.until(ExpectedConditions.elementToBeClickable(PROJECTS)).click();
	}
	
	public void clickOnMyProjects() {
		wait.until(ExpectedConditions.elementToBeClickable(MY_PROJECTS)).click();
	}
	
	public void clickOnDailyMeetingBox() {
		wait.until(ExpectedConditions.elementToBeClickable(QA_SCRUM_MEETING)).click();
	}
	
	public void clickOnSearchName(String name) {
		WebElement search =  wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_NAME));
		search.clear();
		search.click();
		search.sendKeys(name);
	}
	
	public void clickOnTaskName() {
		wait.until(ExpectedConditions.elementToBeClickable(TASK_NAME)).click();
	}
	
//	public void clickOnSlider() {
//		wait.until(ExpectedConditions.elementToBeClickable(renderOnSlider)).click();
//	}

	
	public WebElement getSlider() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(PROGRESS));
	}

	
	public void enterTaskDescription(String descriptionDetails) {
		WebElement taskDetails = wait.until(ExpectedConditions.visibilityOfElementLocated(PROGRESS_DESCRIPTION));
		taskDetails.clear();
		taskDetails.click();
		taskDetails.sendKeys(descriptionDetails);
	}
	
	
	// hold task
	
	public void setAddThisTaskOnHold () {
		wait.until(ExpectedConditions.elementToBeClickable(ADD_THIS_TASK_ON_HOLD)).click();
	}
	
	
	public void enterHoldTaskDescription(String holdReason) {
		WebElement holdTaskDetails = wait.until(ExpectedConditions.elementToBeClickable(REASON));
		holdTaskDetails.clear();
		holdTaskDetails.click();
		holdTaskDetails.sendKeys(holdReason);
	}
	
	public void setAddTaskOnHold() {
		wait.until(ExpectedConditions.elementToBeClickable(ADD_TASK_ON_HOLD)).click();
	}
	
	public String getAlertTaskOnHoldMessageSuccesfully() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_ON_HOLD)).getText();
	}
	
	
	
	//Restart Task
	
	public void clickRestartThisTask() {
		wait.until(ExpectedConditions.elementToBeClickable(RESTART_THIS_TASK)).click();
	}
	
	public void enterRestartDescription(String restartReason) {
		WebElement restartTaskDetails = wait.until(ExpectedConditions.elementToBeClickable(REASON));
		restartTaskDetails.clear();
		restartTaskDetails.click();
		restartTaskDetails.sendKeys(restartReason);
	}
	
	public void clickRestartTask() {
		wait.until(ExpectedConditions.elementToBeClickable(RESTART_TASK)).click();
	}
	
	
	public String getAlertOnTaskRestart() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_RESTART)).getText();
	}
	
	
	
	
	
	public void clickOnCancelButton() {
		wait.until(ExpectedConditions.elementToBeClickable(CANCEL)).click();
	}
	
	public void clickOnOKButton() {
		wait.until(ExpectedConditions.elementToBeClickable(OK)).click();
	}

	public String getTaskUpdatedSuccessfully(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_UPDATED_SUCCESSFULLY )).getText();
    }


	
//	public String getTaskOnHoldMessage() {
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_ON_HOLD)).getText();
//	}
	
	public String getErrorOfProgressDescription() {
	     return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
	}

	public String getErrorOfProgressLowerLimit() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
	}
		
	public int getCurrentProgressValue() {
		String progressValue = wait.until(ExpectedConditions.visibilityOfElementLocated(PROGRESS)).getAttribute("aria-valuenow");
		return Integer.parseInt(progressValue);
}
	

//	public String getTaskOnHoldSuccessfully() {
//		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_TASK_CREATED_SUCCESSFULLY)).getText();
//	}

	
	
}
	

	
	

