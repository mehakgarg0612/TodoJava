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
import org.testng.annotations.Test;

import pageObject.TaskUpdateDetailsPage;
import util.BaseTest;
import utilities.SeleniumMethod;

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
    public void testUpdateWithProgressButNoDescription() {
		
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
	public void deleteTask() {
		SeleniumMethod seleniumMethod = new SeleniumMethod(driver);
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();	
		taskDetails.clickOnSearchName(config.getSearchName());
		
		taskDetails.clickOnDeleteTask("Sunil");
		
		//Assert.assertEquals(taskDetails.getAlertOnTaskDelete() ,"Task deleted successfully");
		//System.out.println("Test case 6 : Validate Task deleted successfully");
		
	}
	
	
	
	
}
