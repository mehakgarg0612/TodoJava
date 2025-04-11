package pageObject;

import java.time.Duration;
import enums.Priority;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskPage {
	
	
	
	//Locator
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	By renderOnProject = By.xpath("//span[text()='Projects']");
	By renderOnMyProjects = By.xpath("//span[text()='My Projects']");
	By dailyMeetingBox = By.xpath("//div[@class='cursor-pointer']");
	
	By addTaskButton = By.xpath("//span[text()='Add Task']");
	By taskNameField = By.xpath("//input[@placeholder='Enter Task Name']");
	By taskDescriptionField = By.xpath("//textarea[@placeholder='Enter Task Description']");
	By startDateField = By.xpath("//input[@id='startDate']");
	By dueDateField = By.xpath("//input[@id='endDate']");
	By priorityDropdown = By.xpath("//input[@id='priority']");
	//By selectPriorityOption = By.xpath("//div[@class='ant-select-item-option-content' and text()='HIGH']");
	By createButton = By.xpath("//span[text()='CREATE']");
	By cancelButton = By.xpath("//span[text()='Cancel']");
	
	
	By taskNameRequiredError = By.xpath("//div[text()='Please enter the Task name']");
	By taskDescriptionRequiredError = By.xpath("//div[text()='Please enter the Task description']");
	By startDateRequiredError = By.xpath("//div[text()='Please select the start date']");
	By dueDateRequiredError = By.xpath("//div[text()='Please select the due date']");
	By selectPriorityTaskError = By.xpath("//div[text()='Please select the Task Priority']");
	
	//Constructor
	
	public CreateTaskPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	}
	
	//Actions
	
	//Actions for filling  correct details
	public void clickOnProject() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnProject)).click();
	}
	
	public void clickOnMyProjects() {
		wait.until(ExpectedConditions.elementToBeClickable(renderOnMyProjects)).click();
	}
	
	public void clickOnDailyMeetingBox() {
		wait.until(ExpectedConditions.elementToBeClickable(dailyMeetingBox)).click();
	}
	
	public void clickAddTask() {
		wait.until(ExpectedConditions.elementToBeClickable(addTaskButton)).click();
		System.out.println("Clicked on Add Task button");
	}
	
	public void enterTaskName(String taskName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskNameField)).sendKeys(taskName);
		 System.out.println("Entered Task Name: " + taskName);
	}
	
	public void enterTaskDescription(String descriptionArea) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskDescriptionField)).sendKeys(descriptionArea);
	}
	
	/**
	 * this method takes an input of start date
	 * @param startDate
	 */
	
	
	
	
	
	public void enterStartDate(String startDate) {
	    try {
	        WebElement startDateElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("startDate")));

	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].value = arguments[1];", startDateElement, startDate);

	        startDateElement.click(); // Focus on the field
	        startDateElement.sendKeys(Keys.ENTER); // Close calendar
	        System.out.println("Entered Start Date: " + startDate);
	    } catch (Exception e) {
	        System.out.println("Failed to enter Start Date: " + e.getMessage());
	        throw e;
	    }
	}

	public void enterDueDate(String dueDate) {
	    try {
	        System.out.println("Calling enterDueDate()...");

	        WebElement dueDateElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("endDate")));

	        JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll into view
	        js.executeScript("arguments[0].scrollIntoView(true);", dueDateElement);

	        // Remove readonly attribute so we can set value
	        js.executeScript("arguments[0].removeAttribute('readonly')", dueDateElement);

	        // Set the date value
	        js.executeScript("arguments[0].value = arguments[1];", dueDateElement, dueDate);

	        // Fire change and blur events to simulate user interaction
	        js.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", dueDateElement);
	        js.executeScript("arguments[0].dispatchEvent(new Event('blur', { bubbles: true }))", dueDateElement);

	        System.out.println("✅ Entered Due Date: " + dueDate);
	    } catch (Exception e) {
	        System.out.println("❌ Failed to enter Due Date: " + e.getMessage());
	        e.printStackTrace();
	        throw e;
	    }
	}



	
//	public void enterStartDate(String startDate) {
//		  driver.findElement((By.id("startDate"))).sendKeys(Keys.ENTER);
//		
//	}
//	
//	
//	
//	public void enterDueDate(String endDate) {
//		 driver.findElement((By.id("endDate"))).sendKeys(Keys.ENTER);
//	}
	



	
//	public void selectPriority(Priority priority) {
//		wait.until(ExpectedConditions.elementToBeClickable(priorityDropdown)).click();
//		By dynamicPriorityOption = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space(text())='" + priority.name() + "']");
//		wait.until(ExpectedConditions.elementToBeClickable(dynamicPriorityOption)).click();
//		System.out.println("Selected Priority: " + priority.name());
//	}
	

	
	
	
	public void selectPriority(Priority priority) {
		
	}
	
	public void clickCreate() {
		wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
	}
	
	public void clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
	}
	
	
	
	
	
	//Actions for incomplete fields
	
	public String getTaskNameError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(taskNameRequiredError)).getText();
	}
	
	public String getDescriptionError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(taskDescriptionRequiredError)).getText();
	}
	public  String getStartDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(startDateRequiredError)).getText();
	}
	public  String getDueDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(dueDateRequiredError)).getText();
	}
	public  String getPrioritySelectError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(selectPriorityTaskError)).getText();
	}


}