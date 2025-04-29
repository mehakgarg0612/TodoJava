package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import pageObject.LoginPage;
import pageObject.RegisterAccountPage;
import util.BaseTest;

public class RegistrationTest extends BaseTest {
	
	@Test(priority = 1)
	public void validRegistrationTest() {
		System.out.println("Starting validRegistrationTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/login"));
		Assert.assertTrue(urlMatched, "Registration failed: Dashboard URL did not match");
		Assert.assertEquals(rp.getSuccessfulRegistrationMessage(),"User Registered Successfully");
		System.out.println("Registration successful!");
		
	}
	
	@Test(priority = 2)
	public void blamkFirstNameTest() {
		System.out.println("Starting blankFirstNameTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	@Test(priority = 3)
	public void blankLastNameTest() {
		System.out.println("Starting blankLastNameTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 4)
	public void blankEmailTest() {
		System.out.println("Starting blankEmailTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 5)
	public void blankEmployeeCodeTest() {
		System.out.println("Starting blankEmployeeCodeTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 6)
	public void blankPasswordTest() {
		System.out.println("Starting blankPasswordTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
		
	@Test(priority = 7)
	public void blankConfirmPasswordTest() {
		System.out.println("Starting blankConfirmPasswordTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 8)
	public void passwordMismatchTest(){
		System.out.println("Starting passwordMismatchTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 9)
	public void invalidEmailFormatTest() {
		System.out.println("Starting invalidEmailFormatTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
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
	
	@Test(priority = 10)
	public void emailAlreadyExistsTest() {
		System.out.println("Starting emailAlreadyExistsTest...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getEmailAlreadyRegisteredError(), "User with this email already exists");
		System.out.println("emailAlreadyExistsTest completed.");
		
	}
	
	@Test(priority = 11)
	
	public void TRCodeShouldBeUnique() {
		System.out.println("Starting TRCodeShouldBeUnique...");
		RegisterAccountPage rp = new RegisterAccountPage(driver);
		rp.clickRegisterAccount();
		rp.enterFirstName(config.getRegFirstName());
		rp.enterLastName(config.getRegLastName());
		rp.enterEmail(config.getRegEmail());
		rp.enterEmployeeCode(config.getRegEmployeeCode());
		rp.enterPassword(config.getRegPassword());
		rp.enterConfirmPassword(config.getRegConfirmPassword());
		rp.clickSubmit();
		
		Assert.assertEquals(rp.getEmployeeCodeUniqueError(), "Employee code should be unique");
		System.out.println("TRCodeShouldBeUnique completed.");
		
	}
	
}
