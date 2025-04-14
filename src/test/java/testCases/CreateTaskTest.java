package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import enums.Priority;
import pageObject.CreateTaskPage;
import util.BaseTest;

public class CreateTaskTest extends BaseTest {
	
	@BeforeMethod
    public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
        login();  // calling login method from BaseTest
    }
	


	@Test(priority = 1)
	 public void createTaskWithValidData() {
		
		 System.out.println("---- Starting createTaskWithValidData ----");

		
		 CreateTaskPage taskPage = new CreateTaskPage(driver);
		 
		 taskPage.clickOnProject();
		 taskPage.clickOnMyProjects();
		 taskPage.clickOnDailyMeetingBox();
		 taskPage.clickAddTask();
		 System.out.println("Clicked on Add Task button");
		 

		taskPage.enterTaskName(config.getTaskName());
		 System.out.println("Clicked on Add Task button1");
		taskPage.enterTaskDescription(config.getDescriptionArea());
		 System.out.println("Clicked on Add Task button2");
		 
		 
	 
		taskPage.enterStartDate(config.getStartDate());
		System.out.println("Clicked on Add Task button3");
		 
		System.out.println("Calling enterDueDate()...");
		taskPage.enterDueDate(config.getDueDate());
		System.out.println("Clicked on Add Task button4");

		 
		


		 Priority priority = Priority.valueOf(config.getTaskPriority().toUpperCase());
	      taskPage.selectPriority(priority);
		 System.out.println("Clicked on Add Task button5");
		 
		 try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		taskPage.clickCreate();
		 System.out.println("Clicked on Create button");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean UrlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/activeproject"));
		Assert.assertTrue(UrlMatched, "Task was not created successfully");
		
	
		System.out.println("Task created successfully with HIGH priority.");
	

		
	}
	
	
	/*@Test(priority = 2)
	
	public void createTaskWithEmptyData() {
		
	
	CreateTaskPage  taskPage = new CreateTaskPage(driver);
	
	taskPage.clickOnProject();
	 taskPage.clickOnMyProjects();
	 taskPage.clickOnDailyMeetingBox();
	
	taskPage.clickAddTask();
	taskPage.enterTaskName("");
	taskPage.enterTaskDescription("");
	taskPage.enterStartDate("");
	taskPage.enterDueDate("");;
	taskPage.clickCreate();
	
	Assert.assertEquals(taskPage.getTaskNameError(), "Please enter the Task name");
	Assert.assertEquals(taskPage.getDescriptionError(), "Please enter the Task description");
	Assert.assertEquals(taskPage.getStartDate(), "Please select the start date");
	Assert.assertEquals(taskPage.getDueDate(),"Please select the due date");
	Assert.assertEquals(taskPage.getPrioritySelectError(),"Please select the Task Priority");
	System.out.println("Task not created successfully with HIGH priority.");
	
	}*/
	
	
	
//	@Test(priority = 3)
//	
//	public void cancelTask() {
//		
//		
//		CreateTaskPage  taskPage = new CreateTaskPage(driver);
//		
//		taskPage.clickOnProject();
//		 taskPage.clickOnMyProjects();
//		 taskPage.clickOnDailyMeetingBox();
//		
//		taskPage.clickAddTask();
//		taskPage.enterTaskName(config.getTaskName());
//		taskPage.enterTaskDescription("");
//		taskPage.enterStartDate("");
//		taskPage.enterDueDate(config.getDueDate());;
//		
//		String priorityFromConfig = config.getTaskPriority().toUpperCase();
//		Priority priority = Priority.valueOf(priorityFromConfig);
//		taskPage.selectPriority(priority);
//		    
//		taskPage.clickCancel();
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		boolean UrlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/activeproject"));
//		Assert.assertTrue(UrlMatched, "Task was not cancel successfully");
//		
//		
//	}
	
//@Test(priority = 4)
//	
//	public void createTaskWithIncompleteData() {
//		
//	
//	CreateTaskPage  taskPage = new CreateTaskPage(driver);
//	
//	taskPage.clickAddTask();
//	taskPage.enterTaskName("Automation testing");
//	taskPage.enterTaskDescription("");
//	taskPage.enterStartDate("");
//	taskPage.enterDueDate("2024-04-10");;
//	taskPage.selectPriority(Priority.HIGH);
//	taskPage.clickCreate();
//	
//	Assert.assertEquals(taskPage.getTaskNameError(), "Please enter the Task name");
//	Assert.assertEquals(taskPage.getDescriptionError(), "Please enter the Task description");
//	Assert.assertEquals(taskPage.getStartDate(), "Please select the start date");
//	Assert.assertEquals(taskPage.getDueDate(),"Please select the due date");
//	Assert.assertEquals(taskPage.getPrioritySelectError(),"Please select the Task Priority");
//	
//	
//	}
	

}
