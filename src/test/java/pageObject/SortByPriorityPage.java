package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortByPriorityPage {
	
	//Locator
	
		private WebDriver driver;
		private WebDriverWait wait;
		
	 	final By PROJECTS = By.xpath("//span[text()='Projects']");
		final By MY_PROJECTS = By.xpath("//span[text()='My Projects']");
		final By QA_SCRUM_MEETING = By.xpath("//div[@class='cursor-pointer']");
		
		//SORTING BY PRIORITY
		final By SORT_BY_PRIORITY = By.xpath("//i[@class='ri-arrow-up-down-line']");
		
		//SORTING BY ALL TASKS
		
		final By ALL_TASKS = By.xpath("//i[@class='ri-team-line']");
		
		
	//SELECT STATUS
		final By SELECT_STATUS = By.xpath("//div[@class = 'ant-select-selector']"); //click on select status
		final By DROPDOWN = By.xpath("//div[contains(@class, 'ant-select-dropdown') and contains(@class, 'ant-select-dropdown-placement-bottomLeft')]"); //dropdown`
		final By SELECT_STATUS_ALL = By.xpath("//div[text() = 'All ']");
		final By SELECT_STATUS_OPEN_WIP_YTS = By.xpath("//div[@class='ant-select-item-option-content' and text()='Open (WIP & YTS) ']"); 
		final By SELECT_STATUS_PENDING = By.xpath("//span[text() = 'Pending']");
		final By SELECT_STATUS_IN_PROGRESS = By.xpath("//span[text() = 'In Progress']");
		final By SELECT_STATUS_ON_HOLD = By.xpath("//span[text() = 'On Hold']");
		
		



//CONSTRUCTOR

public SortByPriorityPage(WebDriver driver){
	this.driver = driver;
	this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
}


// ACTIONS

// SORT BY ALL TASKS
public void clickOnAllTasks() {
	wait.until(ExpectedConditions.elementToBeClickable(ALL_TASKS)).click();
}

// SELECT STATUS

public void selectStatusOnHold() {
		wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS_ON_HOLD)).click();
	}

public void selectStatusInProgress() {
		wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS_IN_PROGRESS)).click();
	}

	public void selectStatusPending() {
		wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS_PENDING)).click();
	}
	
	public void selectStatusOpenWIPYTS() {
		 wait.until(ExpectedConditions.visibilityOfElementLocated(DROPDOWN));
		    wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS_OPEN_WIP_YTS)).click();
	}
	
public void selectStatusAll() {
	wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS_ALL)).click();
}
public void selectStatusDropdown() {
	wait.until(ExpectedConditions.presenceOfElementLocated(DROPDOWN)).click();
}
public void clickOnSelectStatus() {
	wait.until(ExpectedConditions.elementToBeClickable(SELECT_STATUS)).click();
}


// OPENEING OF DASHBOARD PAGE
public void clickOnProject() {
	wait.until(ExpectedConditions.elementToBeClickable(PROJECTS)).click();
}

public void clickOnMyProjects() {
	wait.until(ExpectedConditions.elementToBeClickable(MY_PROJECTS)).click();
}

public void clickOnDailyMeetingBox() {
	wait.until(ExpectedConditions.elementToBeClickable(QA_SCRUM_MEETING)).click();
}


// SORTING BY PRIORITY
public void sortPriority() {
	wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_PRIORITY)).click();

}



 }