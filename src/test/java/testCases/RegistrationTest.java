package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import dev.failsafe.internal.util.Maths;
import pageObject.DashboardPage;
import pageObject.LoginPage;
import pageObject.RegisterAccountPage;
import util.BaseTest;
import util.ExtentReportListener;


@Listeners(util.ExtentReportListener.class) 
public class RegistrationTest extends BaseTest {
	
	
	@Test(groups = "regression", priority = 1)
	public void validRegistrationTest() {
		ExtentReportListener.getTest().info("Starting validRegistrationTest...");
		System.out.println("Starting validRegistrationTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		DashboardPage dp = new DashboardPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		
		String randomPrefix = "Test" + (int)(Math.random() * 1000); // e.g., Math427
		String email = randomPrefix + "." + config.getRegEmail();
		rp.enterEmail(email);
		
		
//		rp.enterEmail(config.getRegEmail());
		
		String randomEmpCode = "TR" + (int)(Math.random() * 1000); // e.g., TR427
		rp.enterEmployeeCode(randomEmpCode);

		//rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(30));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/login"));
		LoginPage lp = new LoginPage(getDriver());
		lp.setEmail(email);
		lp.setPassword(config.getRegPassword());
		lp.clickLogin();
		
		
		dp.isdashboardBtnVisible();
		Assert.assertTrue(urlMatched, "Registration failed: Dashboard URL did not match");
		Assert.assertEquals(rp.getSuccessfulRegistrationMessage(),"User Registered Successfully");
		System.out.println("Registration successful!");
		
	}
	
	@Test(groups = "regression", priority = 2)
	public void blankFirstNameTest() {
		System.out.println("Starting blankFirstNameTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName("");
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getFirstNameRequiredError(), "First Name is required");
		System.out.println("blankFirstNameTest completed.");
		
	}
	@Test(groups = "regression", priority = 3)
	public void blankLastNameTest() {
		System.out.println("Starting blankLastNameTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName("");
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getLastNameRequiredError(), "Last Name is required");
		System.out.println("blankLastNameTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 4)
	public void blankEmailTest() {
		System.out.println("Starting blankEmailTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail("");
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getEmailRequiredError(), "Email is required");
		System.out.println("blankEmailTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 5)
	public void blankEmployeeCodeTest() {
		System.out.println("Starting blankEmployeeCodeTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode("");
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getEmployeeCodeRequiredError(), "Employee Code is required");
		System.out.println("blankEmployeeCodeTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 6)
	public void blankPasswordTest() {
		System.out.println("Starting blankPasswordTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword("");
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getPasswordRequiredError(), "Password is required");
		System.out.println("blankPasswordTest completed.");
		
	}
	
		
	@Test(groups = "regression", priority = 7)
	public void blankConfirmPasswordTest() {
		System.out.println("Starting blankConfirmPasswordTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword("");
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getConfirmPasswordRequiredError(), "Please confirm your password");
		System.out.println("blankConfirmPasswordTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 8)
	public void passwordMismatchTest(){
		System.out.println("Starting passwordMismatchTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword("Komal");
		rp.clickSubmit();

		Assert.assertEquals(rp.getPasswordMismatchError(), "The passwords do not match");
		System.out.println("passwordMismatchTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 9)
	public void invalidEmailFormatTest() {
		System.out.println("Starting invalidEmailFormatTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail("komalgarg.idsil.com");
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getInvalidEmailFormatError(), "Invalid email format");
		System.out.println("invalidEmailFormatTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 10)
	public void emailAlreadyExistsTest() {
		System.out.println("Starting emailAlreadyExistsTest...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getAlreadyRegisteredEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getEmailAlreadyRegisteredError(), "User with this email already exists");
		System.out.println("emailAlreadyExistsTest completed.");
		
	}
	
	@Test(groups = "regression", priority = 11)
	
	public void TRCodeShouldBeUnique() {
		System.out.println("Starting TRCodeShouldBeUnique...");
		RegisterAccountPage rp = new RegisterAccountPage(getDriver());
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		String randomPrefix = "Test" + (int)(Math.random() * 1000); // e.g., Math427
		String email = randomPrefix + "." + config.getRegEmailtrCode();
		rp.enterEmail(email);
		rp.enterEmployeeCode(config.getAlreadyRegisteredEmpCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		System.out.println(rp.getEmployeeCodeUniqueError());
		Assert.assertEquals(rp.getEmployeeCodeUniqueError(), "Employee code should be unique");
		System.out.println("TRCodeShouldBeUnique completed.");
		
	}
	
}
