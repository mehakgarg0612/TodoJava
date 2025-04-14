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
		 
		// wait.until(ExpectedConditions.attributeToBe(slider, "aria-valuenow", "30"));

		 taskDetails.enterTaskDescription(config.getTaskDescriptionOfCreatedTask());
	
		taskDetails.clickOnOKButton();
	
		Assert.assertEquals(taskDetails.getAlertMessage() ,"Task updated successfully");
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

       
        
        Assert.assertEquals(taskDetails.getAlertMessage(), "Please enter Progress Description");
        System.out.println("Test Case 2: Validation message displayed for missing description");
    }

//	
//	@Test(priority = 3)
//	
//	public void taskUpdateWithoutProgress() {
//		
//		TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		
//		taskDetails.clickOnProject();
//		taskDetails.clickOnMyProjects();
//		taskDetails.clickOnDailyMeetingBox();
//		taskDetails.clickOnSearchName(config.getSearchName());
//		taskDetails.clickOnTaskName();
//		
//		WebElement slider = taskDetails.getSlider();
//		 Actions act = new Actions(driver);
//		 act.clickAndHold(slider).moveByOffset(0, 0).release().perform();
//		 
//		 taskDetails.enterTaskDescription(config.getTaskDescriptionOfCreatedTask());
//		 taskDetails.clickOnOKButton();
//		 
//		 wait.until(ExpectedConditions.visibilityOfElementLocated(
//		            By.xpath("//span[contains(text(),'Progress cannot be lower or equal to 44%')]")));
//		 
//		 Assert.assertEquals(taskDetails.getErrorOfProgressLowerLimit() ,"Progress cannot be lower or equal to 44%");
//		 System.out.println("Test Case 3 : Validation progess cannot be lower than the prevoius one");
//		
//	}
    
//	
//	@Test(priority = 3)
//    public void testClickOkWithProgressLessThanOrEqualToLast() throws InterruptedException {
//        TaskUpdateDetailsPage taskDetails = new TaskUpdateDetailsPage(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//   
//        taskDetails.clickOnProject();
//        taskDetails.clickOnMyProjects();
//        taskDetails.clickOnDailyMeetingBox();
//        taskDetails.clickOnSearchName(config.getSearchName());
//        taskDetails.clickOnTaskName();
//
//       
//        WebElement slider = taskDetails.getSlider();
//        Actions act = new Actions(driver);
//        act.clickAndHold(slider).moveByOffset(-10, 0).release().perform(); 
//
// 
//        taskDetails.enterTaskDescription("Test description");
//
//     
//        taskDetails.clickOnOKButton();
//
//      
//        WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//span[contains(text(),'Progress cannot be lower or equal to 44%')]")));
//        
//        Assert.assertEquals(validationMessage.getText(), "Progress cannot be lower or equal to 44%",
//                "Validation message for invalid progress should be displayed");
//        System.out.println("Test Case 3: Validation message displayed for invalid progress");
//    }
}
