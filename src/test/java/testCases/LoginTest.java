package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import pageObject.LogoutPage;
import testBase.BaseClass;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginTest extends BaseClass {

	//LoginPage lp; 
	
	@Test(priority = 1)
	public void validLoginTest() {
		System.out.println("Starting validLoginTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/dashboard"));
		Assert.assertTrue(urlMatched, "Login failed: Dashboard URL did not match");
		System.out.println("Login successful!");

		LogoutPage logout = new LogoutPage(driver);
		logout.logout();
		System.out.println("validLoginTest completed.");
	}

	@Test(priority = 2)
	public void blankEmailAndPasswordTest() {
		System.out.println("Starting blankEmailAndPasswordTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("");
		lp.setPassword("");
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailRequiredError(), "Email is required");
		Assert.assertEquals(lp.getPasswordRequiredError(), "Password is required");
		System.out.println("blankEmailAndPasswordTest completed.");
	}

	@Test(priority = 3)
	public void blankEmailTest() {
		System.out.println("Starting blankEmailTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailRequiredError(), "Email is required");
		System.out.println("blankEmailTest completed.");
	}

	@Test(priority = 4)
	public void blankPasswordTest() {
		System.out.println("Starting blankPasswordTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword("");
		lp.clickLogin();
		Assert.assertEquals(lp.getPasswordRequiredError(), "Password is required");
		System.out.println("blankPasswordTest completed.");
	}

	@Test(priority = 5)
	public void invalidEmailFormatTest() {
		System.out.println("Starting invalidEmailFormatTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehakgarg.idsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailFormatError(), "Invalid email format");
		System.out.println("invalidEmailFormatTest completed.");
	}

	@Test(priority = 6)
	public void userNotExistTest() {
		System.out.println("Starting userNotExistTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehakgarg@idsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getUserNotExistError(), "User does not exist");
		System.out.println("userNotExistTest completed.");
	}

//	@Test(priority = 7)
//	public void wrongPasswordTest() {
//		System.out.println("Starting wrongPasswordTest...");
//		LoginPage lp = new LoginPage(driver);
//		lp.setEmail(config.getEmail());
//		lp.setPassword("mehak");
//		lp.clickLogin();
//
//		Assert.assertEquals(lp.getWrongPasswordError(), "Incorrect Password");
//		System.out.println("wrongPasswordTest completed.");
//	}
}