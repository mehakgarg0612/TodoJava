package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.SortByPriorityPage;
import util.BaseTest;


@Listeners(util.ExtentReportListener.class) 
public class SortByPriorityTest extends BaseTest {
	
	 @BeforeMethod public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----"); 
		  login();
		  }  //calling login method from BaseTest 

	
	@Test(groups = "regression", priority = 1)
	public void selectByHighPriority() throws InterruptedException {
		
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		
		sortPriority.sortPriority();
		Thread.sleep(6000);
	}
	
	//SELECT STATUS
	@Test(groups = "regression", priority = 2) // success of test case
	public void selectByStatusAll() {
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
	
		
		sortPriority.selectStatusAll();
		System.out.println("Validate the by clicking 'All status' is visible");
		
	}
	
	@Test(groups = "regression", priority = 3) // success of test case
	public void selectByOpenWIP_YTS()  {
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.selectStatusOpenWIPYTS();
		System.out.println("Validate the by clicking 'Open/WIP/YTS' is visible");
		
	}
	
	@Test(groups = "regression", priority = 4)// success of test case
	public void selectByPending() {
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.selectStatusPending();
		System.out.println("Validate the by clicking 'Pending' is visible");
		
	}
	
	
	@Test(groups = "regression", priority = 5)// success of test case
	public void selectByInProgress()  {
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		//sortPriority.clickOnSelectStatus();
		//sortPriority.selectStatusDropdown();
		
		sortPriority.selectStatusInProgress();
		System.out.println("Validate the by clicking 'In Progress' is visible");
		
	}
	
	@Test(groups = "regression", priority = 6)// success of test case
	public void selectByOnHold(){		
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.selectStatusOnHold();
		System.out.println("Validate the by clicking 'On Hold' is visible");
	}
	
	
	//TASKS ICON
	@Test(groups = "regression", priority = 7)
	
	public void sortByAllTasks() throws InterruptedException {
		SortByPriorityPage sortPriority = new SortByPriorityPage(getDriver());
		sortPriority.clickOnProject();
		sortPriority.clickOnMyProjects();
		sortPriority.clickOnDailyMeetingBox();
		
		sortPriority.clickOnAllTasks();
		Thread.sleep(7000);
		System.out.println("Validate the by clicking 'All Tasks' is visible");
		
	}
	
}
