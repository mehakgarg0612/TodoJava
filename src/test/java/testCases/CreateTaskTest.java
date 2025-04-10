package testCases;

import org.testng.annotations.Test;

import Util.BaseTest;
import enums.Priority;
import pageObject.CreateTaskPage;

public class CreateTaskTest extends BaseTest {
	
	@Test
	 public void createTaskWithValidData() {
		
		CreateTaskPage taskPage = new CreateTaskPage(driver);
		
		taskPage.clickAddTask();
		taskPage.enterTaskName("Automation testing");
		taskPage.enterTaskDescription("Task created by Selenium");
		taskPage.enterStartDate("2024-04-08");
		taskPage.enterDueDate("2024-04-10");;
		taskPage.selectPriority(Priority.HIGH);
		taskPage.clickCreate();
		
	}
	
	

}
