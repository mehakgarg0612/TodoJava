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

	@Test(priority = 1)
	public void validLoginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/dashboard"));
		Assert.assertTrue(urlMatched, "Login failed: Dashboard URL did not match");

		LogoutPage logout = new LogoutPage(driver);
		logout.logout();
	}

	@Test(priority = 2)
	public void blankEmailAndPasswordTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("");
		lp.setPassword("");
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailRequiredError(), "Email is required");
		Assert.assertEquals(lp.getPasswordRequiredError(), "Password is required");
	}

	@Test(priority = 3)
	public void blankEmail() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailRequiredError(), "Email is required");
	}

	@Test(priority = 4)
	public void blankPassword() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword("");
		lp.clickLogin();

		Assert.assertEquals(lp.getPasswordRequiredError(), "Password is required");
	}

	@Test(priority = 5)
	public void invalidEmailFormatTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehak.gargidsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getEmailFormatError(), "Invalid email format");
	}

	@Test(priority = 6)
	public void userNotExistTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail("mehaarg@idsil.com");
		lp.setPassword(config.getPassword());
		lp.clickLogin();

		Assert.assertEquals(lp.getUserNotExistError(), "User does not exist");
	}

	@Test(priority = 7)
	public void wrongPasswordTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword("mehak123");
		lp.clickLogin();

		Assert.assertEquals(lp.getWrongPasswordError(), "Incorrect Password");
	}
}
