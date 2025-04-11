package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.TaskUpdateDetailsPage;
import util.BaseTest;

public class TaskUpdateDetailsTest extends BaseTest {

	
	 public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
        login();  // calling login method from BaseTest
    }
	
	@Test
	public void taskUpdateValidCrendentials() {
		
		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
		
		taskDetails.clickOnProject();
		taskDetails.clickOnMyProjects();
		taskDetails.clickOnDailyMeetingBox();
		taskDetails.clickOnSearchName(config.getSearchName());
		taskDetails.clickOnTaskName();
		
		taskDetails.clickOnSlider();
		
		taskDetails.enterTaskDescription(config.getTaskDescriptionOfCreatedTask());
		taskDetails.clickOnOKButton();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean UrlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/activeproject"));
		Assert.assertTrue(UrlMatched, "Task was not created successfully");
		
	
		System.out.println("Task updated successfully");
		
		
	}
	
	
}
