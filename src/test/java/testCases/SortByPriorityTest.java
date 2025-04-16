package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.SortByPriorityPage;
import util.BaseTest;

public class SortByPriorityTest extends BaseTest {
	
	@BeforeMethod
    public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
        login();  // calling login method from BaseTest
    }
	
	
	
	
	@Test(priority = 1)
	public void selectByHighPriority() throws InterruptedException {
		
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		Thread.sleep(6000);
		sortPriority.sortPriority();
		Thread.sleep(6000);
		
		
		
	}
	

	@Test(priority = 2)
	public void selectByLowPriority() {
		
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		sortPriority.sortPriority();
		
		
		
	}
		
	
	
	

}
