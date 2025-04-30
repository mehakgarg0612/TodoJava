package testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import pageObject.LogoutPage;
import util.BaseTest;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


@Listeners(util.Listener.class)
public class LoginTest extends BaseTest {

	//LoginPage lp;
	
	@Test(groups = "regression")
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

	@Test(groups = "regression")
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

	@Test(groups = "regression")
	public void blankEmailTest() {
		System.out.println("Starting blankEmailTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailRequiredError(), "Email is required");
		System.out.println("blankEmailTest completed.");
	}

	@Test(groups = "regression")
	public void blankPasswordTest() {
		System.out.println("Starting blankPasswordTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword("");
		lp.clickLogin();
		Assert.assertEquals(lp.getPasswordRequiredError(), "Password is required");
		System.out.println("blankPasswordTest completed.");
	}

	@Test(groups = "regression")
	public void invalidEmailFormatTest() {
		System.out.println("Starting invalidEmailFormatTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehakgarg.idsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailFormatError(), "Invalid email format");
		System.out.println("invalidEmailFormatTest completed.");
	}

	@Test(groups = "regression")
	public void userNotExistTest() {
		System.out.println("Starting userNotExistTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehakgarg2@idsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();
		
		Assert.assertEquals(lp.getUserNotExistError(), "User does not exist");
		System.out.println("userNotExistTest completed.");
	}

	@Test(groups = "regression")
	public void wrongPasswordTest() {
		System.out.println("Starting wrongPasswordTest...");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword("mehak");
		lp.clickLogin();

		Assert.assertEquals(lp.getWrongPasswordError(), "Incorrect Password");
		System.out.println("wrongPasswordTest completed.");
	}
}