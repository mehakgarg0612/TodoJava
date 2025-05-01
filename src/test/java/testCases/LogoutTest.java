package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.FinalLogoutPage;
import util.BaseTest;


@Listeners(util.ExtentReportListener.class) 
public class LogoutTest extends BaseTest {
	
	@BeforeMethod
	public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
       login();  // calling login method from BaseTest
   }
	
	@Test(priority = 1)
	public void logoutTest() {
		FinalLogoutPage lp = new FinalLogoutPage(driver);
		lp.clickOnProfileMenu();
		lp.clickOnLogoutButton();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/login"));
		Assert.assertTrue(urlMatched, "Logout failed: Logout did not match");
		System.out.println("Logoutsuccessful!");
	}
	
	
	

	
	

}
