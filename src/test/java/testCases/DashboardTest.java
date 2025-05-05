package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import util.BaseTest;

@Listeners(util.ExtentReportListener.class)
public class DashboardTest extends BaseTest {
	
	  @BeforeMethod public void loginBeforeEachTest() {
			 System.out.println("---- Running loginBeforeEachTest ----"); 
			  login(); } 

	@Test(groups = "regression", priority = 1)
    public void verifyDashboardElements() {

		

        DashboardPage dp = new DashboardPage(getDriver());
        String greeting = dp.getGreetingMessage();
        Assert.assertTrue(greeting.contains("Hello"), "Greeting message not found");

        String taskCount = dp.getTaskCount();
        Assert.assertFalse(taskCount.isEmpty(), "Task count is empty");

        String projectCount = dp.getProjectCount();
        Assert.assertFalse(projectCount.isEmpty(), "Project count is empty");

        Assert.assertTrue(dp.isCompletedTasksVisible(), "Completed task chart is not visible");
        Assert.assertTrue(dp.isProgessTaskbarVisible(), "Progress task chart is not visible");
        Assert.assertTrue(dp.isPendingTaskbarVisible(), "Pending task chart is not visible");

        LogoutPage logout = new LogoutPage(getDriver());
        logout.logout();
    }
}
