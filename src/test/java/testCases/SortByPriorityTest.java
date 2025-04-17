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
		
		
		sortPriority.sortPriority();
		Thread.sleep(6000);
	}
	
	//SELECT STATUS
	@Test(priority = 2)
	public void selectByStatusAll() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		sortPriority.clickOnSelectStatus();
		
		sortPriority.selectStatusAll();
		Thread.sleep(9000);
		System.out.println("Validate the by clicking 'All status' is visible");
		
	}
	
	@Test(priority = 3)
	public void selectByOpenWIP_YTS() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		sortPriority.clickOnSelectStatus();
		sortPriority.selectStatusDropdown();
		
		sortPriority.selectStatusOpenWIPYTS();
		Thread.sleep(6000);
		System.out.println("Validate the by clicking 'Open/WIP/YTS' is visible");
		
	}
	
	@Test(priority = 4)
	public void selectByPending() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.selectStatusPending();
		Thread.sleep(9000);
		System.out.println("Validate the by clicking 'Pending' is visible");
		
	}
	
	
	@Test(priority = 5)
	public void selectByInProgress() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.selectStatusInProgress();
		Thread.sleep(9000);
		System.out.println("Validate the by clicking 'In Progress' is visible");
		
	}
		
	@Test(priority = 6)
	
	public void sortByAllTasks() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(driver);
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.clickOnAllTasks();
		System.out.println("Validate the by clicking 'All Tasks' is visible");
		
	}
	
}
