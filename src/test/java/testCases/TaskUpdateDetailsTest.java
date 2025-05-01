package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import enums.Priority;
import pageObject.TaskUpdateDetailsPage;
import util.BaseTest;
import utilities.SeleniumMethod;


@Listeners(util.ExtentReportListener.class) 
public class TaskUpdateDetailsTest extends BaseTest {

	@BeforeMethod
	 public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
        login();  // calling login method from BaseTest
    }
	
	@Test(priority = 1)
	public void taskUpdateValidCrendentials() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();
		taskDetails.clickOnSearchName(config.getSearchName());
		taskDetails.clickOnTaskName();

		 
		 WebElement slider = taskDetails.getSlider();
		 Actions act = new Actions(driver);
		 act.clickAndHold(slider).moveByOffset(30, 0).release().perform();
		 

		 taskDetails.enterTaskDescription(config.getTaskDescriptionOfCreatedTask());
	
		taskDetails.clickOnOKButton();
	
		Assert.assertEquals(taskDetails.getTaskUpdatedSuccessfully() ,"Task updated successfully");
		System.out.println("Test case 1 : Validate Task updated successfully");
		
	}
	
	
	@Test(priority = 2)
    public void taskUpdateWithProgressButNoDescription() {
		
        TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    
        taskDetails.clickOnProject();
        taskDetails.clickOnMyProjects();
        taskDetails.clickOnDailyMeetingBox();
        taskDetails.clickOnSearchName(config.getSearchName());
        taskDetails.clickOnTaskName();

     
        WebElement slider = taskDetails.getSlider();
        Actions act = new Actions(driver);
        act.clickAndHold(slider).moveByOffset(40, 0).release().perform(); 

       
        taskDetails.enterTaskDescription(""); 
        taskDetails.clickOnOKButton();

       
        
        Assert.assertEquals(taskDetails.getErrorOfProgressDescription(), "Please enter Progress Description");
        System.out.println("Test Case 2: Validation message displayed for missing description");
    }

	
	@Test(priority = 3)
	
	public void taskUpdateWithoutProgress() throws InterruptedException {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();
		taskDetails.clickOnSearchName(config.getSearchName());
		taskDetails.clickOnTaskName();
		
		WebElement slider = taskDetails.getSlider();
		 Actions act = new Actions(driver);
		 act.clickAndHold(slider).moveByOffset(0, 0).release().perform();
		 
		   int currentValue = taskDetails.getCurrentProgressValue();
		 
		 taskDetails.enterTaskDescription(config.getTaskDescriptionOfCreatedTask());
		 taskDetails.clickOnOKButton();
		 
		 String expectedMessage = String.format("Progress cannot be lower or equal to %d%%.", currentValue);

		 Assert.assertEquals(taskDetails.getErrorOfProgressLowerLimit(), expectedMessage);
		    
	     System.out.println("Test Case: Validation message displayed for progress not increased - " + expectedMessage);
		
	}
    

	@Test(priority = 4)
	
	public void addTaskOnHold() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		taskDetails.clickOnTaskName();
		
		taskDetails.setAddThisTaskOnHold();
		taskDetails.enterHoldTaskDescription(config.getTaskOnHoldReason());
		taskDetails.setAddTaskOnHold();
		
		Assert.assertEquals(taskDetails.getAlertTaskOnHoldMessageSuccesfully() ,"Task Restarted");
		System.out.println("Test case 4 : Validate Task updated ON-HOLD successfully");
		
	}
	
	
	
	@Test(priority = 5)
	public void restartTask() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		taskDetails.clickOnTaskName();
		
		taskDetails.clickRestartThisTask();
		taskDetails.enterRestartDescription(config.getRestartTaskReason());
		taskDetails.clickRestartTask();
		
		Assert.assertEquals(taskDetails.getAlertOnTaskRestart() ,"Task is On-Hold");
		System.out.println("Test case 5 : Validate Task restarted successfully");
		
	}	
	
	
	@Test(priority = 6)
	
	public void taskUpdateWithPenButton() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		//taskDetails.clickOnTaskName();
		
		taskDetails.clickOnUpdateTask("Mehaktesting"); //----  you need to hardcode the task name here -------
		taskDetails.enterUpdateTaskName("Mehaktesting");
		taskDetails.enterUpdateTaskDescription("Mehaktesting");
		
		 Priority priority = Priority.valueOf(config.getTaskPriority().toUpperCase());
	      taskDetails.selectPriority(priority);
	      
		 System.out.println("low priority");
		taskDetails.clickOnUpdate();
		
		Assert.assertEquals(taskDetails.getTaskUpdatedSuccessfully() ,"Task updated successfully");
		System.out.println("Test case 7 : Validate Task updated successfully");
		
	}
	
	
	@Test(priority = 7)
	public void taskUpdateWithPenButtonWithoutTaskName() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		//taskDetails.clickOnTaskName();
		
		taskDetails.clickOnUpdateTask("Mehaktesting"); // Hardcore
		taskDetails.enterUpdateTaskName("");
		taskDetails.enterUpdateTaskDescription("Mehaktesting");
		
		 Priority priority = Priority.valueOf(config.getTaskPriority().toUpperCase());
	      taskDetails.selectPriority(priority);
	      
		 System.out.println("low priority");
		taskDetails.clickOnUpdate();
		
		Assert.assertEquals(taskDetails.getTaskNameError(), "Please enter the Task name");
		System.out.println("Test case 9 : Validate Task updated successfully");
		
	}
	
	@Test(priority = 8)
	public void taskUpdateWithPenButtonWithoutTaskDescription() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		//taskDetails.clickOnTaskName();
		
		taskDetails.clickOnUpdateTask("Mehaktesting");
		taskDetails.enterUpdateTaskName("Mehaktesting");
		taskDetails.enterUpdateTaskDescription("");
		
		 Priority priority = Priority.valueOf(config.getTaskPriority().toUpperCase());
	      taskDetails.selectPriority(priority);
	      
		 System.out.println("low priority");
		taskDetails.clickOnUpdate();
		
		Assert.assertEquals(taskDetails.getTaskDescriptionError(), "Please enter the Task description");
		System.out.println("Test case 8 : Validate Task updated successfully");
		
	}
	
	
	@Test(priority = 9)
	public void deleteTask() {
		SeleniumMethod seleniumMethod = new SeleniumMethod(driver);
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		
		taskDetails.clickOnDeleteTask("Mehak");
		
		Assert.assertEquals(taskDetails.getTaskDeletedSuccessfully() ,"Task deleted successfully");
		System.out.println("Test case 6 : Validate Task deleted successfully");
		
	}
	

	
}
