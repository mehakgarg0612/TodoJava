package pageObject;

import java.time.Duration;
import enums.Priority;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateTaskPage {
	
	
	
	//Locator
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	By addTaskButton = By.xpath("//span[text()='Add Task']");
	By taskNameField = By.xpath("//input[@placeholder='Enter Task Name']");
	By taskDescriptionField = By.xpath("//textarea[@placeholder='Enter Task Description']");
	By startDateField = By.xpath("//input[@id='startDate']");
	By dueDateField = By.xpath("//input[@id='endDate']");
	By priorityDropdown = By.xpath("//input[@id='priority']");
	//By selectPriorityOption = By.xpath("//div[@class='ant-select-item-option-content' and text()='HIGH']");
	By createButton = By.xpath("//span[text()='CREATE']");
	By cancelButton = By.xpath("//span[text()='Cancel']");
	
	//Constructor
	
	public CreateTaskPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	}
	
	//Actions
	
	public void clickAddTask() {
		wait.until(ExpectedConditions.elementToBeClickable(addTaskButton)).click();
	}
	
	public void enterTaskName(String taskName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskNameField)).sendKeys(taskName);
	}
	
	public void enterTaskDescription(String descriptionArea) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskDescriptionField)).sendKeys(descriptionArea);
	}
	
	public void enterStartDate(String startDate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(startDateField)).sendKeys(startDate);
	}
	public void enterDueDate(String endDate) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(startDateField)).sendKeys(endDate);
	}
	public void selectPriority(Priority priority) {
		wait.until(ExpectedConditions.elementToBeClickable(priorityDropdown)).click();
		By dynamicPriorityOption = By.xpath("//div[@class='ant-select-item-option-content' and text()=' " + priority.name() +"']");
		wait.until(ExpectedConditions.elementToBeClickable(dynamicPriorityOption));
	}
	public void clickCreate() {
		wait.until(ExpectedConditions.elementToBeClickable(createButton)).click();
	}
	
	public void clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(cancelButton)).click();
	}
	
	
	

}