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
	
 	final By PROJECTS = By.xpath("//span[text()='Projects']");
	final By MY_PROJECTS = By.xpath("//span[text()='My Projects']");
	final By QA_SCRUM_MEETING = By.xpath("//div[@class='cursor-pointer']");
	
	final By ADD_TASK = By.xpath("//span[text()='Add Task']");
	final By TASK_NAME = By.xpath("//input[@placeholder='Enter Task Name']");
	final By TASK_DESCRIPTION = By.xpath("//textarea[@placeholder='Enter Task Description']");
	
	
	final By START_DATE = By.xpath("//input[@id='startDate']");
	final By CALENDER = By.xpath("//div[@class='ant-picker-header-view']");
    final By MONTH = By.xpath("//div[@class='ant-picker-header-view']/button[@class='ant-picker-month-btn']");
    final By YEAR = By.xpath("//div[@class='ant-picker-header-view']/button[@class='ant-picker-year-btn']");
    final By DUE_DATE = By.xpath("//input[@id='endDate']");
 
	
    final By PRIORITY = By.xpath("//input[@id='priority']");
	final By CREATE = By.xpath("//span[text()='CREATE']");
	final By CANCEL = By.xpath("//span[text()='Cancel']");
	
	
	final By TASK_NAME_REQUIRED_ERROR = By.xpath("//div[text()='Please enter the Task name']");
	final By TASK_DESCRIPTION_REQUIRED_ERROR = By.xpath("//div[text()='Please enter the Task description']");
	final By START_DATE_REQUIRED_ERROR = By.xpath("//div[text()='Please select the start date']");
	final By DUE_DATE_REQUIRED_ERROR = By.xpath("//div[text()='Please select the due date']");
	final By SELECT_PRIORITY_ERROR = By.xpath("//div[text()='Please select the Task Priority']");
	
	//Constructor
	
	public CreateTaskPage(WebDriver driver){
		this.driver = driver;
		this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
	}
	
	//Actions
	
	//Actions for filling  correct details
	public void clickOnProject() {
		wait.until(ExpectedConditions.elementToBeClickable(PROJECTS)).click();
	}
	
	public void clickOnMyProjects() {
		wait.until(ExpectedConditions.elementToBeClickable(MY_PROJECTS)).click();
	}
	
	public void clickOnDailyMeetingBox() {
		wait.until(ExpectedConditions.elementToBeClickable(QA_SCRUM_MEETING)).click();
	}
	
	public void clickAddTask() {
		wait.until(ExpectedConditions.elementToBeClickable(ADD_TASK)).click();
		System.out.println("Clicked on Add Task button");
	}
	
	public void enterTaskName(String taskName) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_NAME)).sendKeys(taskName);
		 System.out.println("Entered Task Name: " + taskName);
	}
	
	public void enterTaskDescription(String descriptionArea) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_DESCRIPTION)).sendKeys(descriptionArea);
	}
	
	/**
	 * this method takes an input of start date
	 * @param startDate
	 */
	
		public void enterStartDate(String startDate) {
		WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("startDate")));
		startDateInput.clear(); 
		startDateInput.click(); 
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-picker-body']//table[@class='ant-picker-content']")));
		String monthYearValue = driver.findElement(By.xpath("ant-picker-header-view")).getText();
}
		
		
	
		public void enterDueDate(String endDate) {
			driver.findElement((By.id("endDate"))).sendKeys(Keys.ENTER);
	}
	
		By datePickerInput = By.id("//div[@class='ant-picker-header-view']");
	    By displayedMonth = By.xpath("//div[@class='ant-picker-header']//button[contains(@class, 'ant-picker-month-btn')]");
	    By displayedYear = By.xpath("//div[@class='ant-picker-header']//button[contains(@class, 'ant-picker-year-btn')]");
	   // By nextMonthButton = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']");
	    // Replace day locator dynamically

	    // Action Method
//	    public void selectDueDate(String year, String month, String day) {
//	        driver.findElement(datePickerInput).click(); // Open date picker
//
//	        while (true) {
//	            String currentMonth = driver.findElement(displayedMonth).getText();
//	            String currentYear = driver.findElement(displayedYear).getText();
//
//	            if (currentMonth.equals(month) && currentYear.equals(year)) {
//	                break;
//	            }
//	            driver.findElement(nextMonthButton).click();
//	        }
//
//	        // Select the day
//	        driver.findElement(By.xpath("//a[text()='" + day + "']")).click();
//	    }
//
//	 public void selectDueDate(String year, String month, String day) {
//	        driver.findElement(datePickerInput).click(); // Open date picker
//
//	        while (true) {
//	            String currentMonth = driver.findElement(displayedMonth).getText();
//	            String currentYear = driver.findElement(displayedYear).getText();
//
//	            if (currentMonth.equals(month) && currentYear.equals(year)) {
//	                break;
//	            }
//	            driver.findElement(nextMonthButton).click();
//	        }

		
//	public void enterStartDate(String startDate) {
//		  driver.findElement((By.id("startDate"))).sendKeys(Keys.ENTER);
//		
//	}
//
//	public void enterDueDate(String endDate) {
//	 driver.findElement((By.id("endDate"))).sendKeys(Keys.ENTER);
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
		wait.until(ExpectedConditions.elementToBeClickable(CREATE)).click();
	}
	
	public void clickCancel() {
		wait.until(ExpectedConditions.elementToBeClickable(CANCEL)).click();
	}
	
	
	//Actions for incomplete fields
	
	public String getTaskNameError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(TASK_NAME_REQUIRED_ERROR)).getText();
	}
	
	public String  getTaskDecription() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated( TASK_DESCRIPTION_REQUIRED_ERROR)).getText();
	}
	public  String getStartDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(START_DATE_REQUIRED_ERROR)).getText();
	}
	public  String getDueDate() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(DUE_DATE_REQUIRED_ERROR)).getText();
	}
	public  String getPrioritySelectError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SELECT_PRIORITY_ERROR)).getText();
	}


}