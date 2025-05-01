package testCases;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.MyProfilePage;
import util.BaseTest;


@Listeners(util.ExtentReportListener.class) 
public class MyProfileTest extends BaseTest {
	
	@BeforeMethod
	public void loginBeforeEachTest() {
		 System.out.println("---- Running loginBeforeEachTest ----");
       login();  // calling login method from BaseTest
   }
	
	
	//MY PROFILE
	@Test(groups = "regression") // Success of the test case
	public void myProfileValidCredentials() {
		
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnMyProfile();
		myProfile.clickOnEditProfile();
		myProfile.setFirstName(config.getFirstName());
		myProfile.setLastName(config.getLastName());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getAlertMessage(), "Profile Updated Successfully");
		System.out.println("Test case 1 : Validate Profile updated successfully");
		
	}
	
	@Test(groups = "regression") // success of the test case
	public void myProfileWithEmptyFirstName() {
		
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnMyProfile();
		myProfile.clickOnEditProfile();
		myProfile.setFirstName("");
		myProfile.setLastName(config.getLastName());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getFirstNameRequiredError(), "Firstname Required");
		System.out.println("Test case 2 : Validate Profile updated successfully");
	}
	
	@Test(groups = "regression")
	public void myProfileWithEmptyLastName() {
		
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnMyProfile();
		myProfile.clickOnEditProfile();
		myProfile.setFirstName(config.getFirstName());
		myProfile.setLastName("");
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getLastNameRequiredError(), "Lastname Required");
		System.out.println("Test case 3 : Validate Profile updated successfully");
		
	}
	
	@Test(groups = "regression") // Failure of the test case
	public void myProfileWithWhitespaceOnlyFirstName() {
	    MyProfilePage myProfile = new MyProfilePage(driver);
	    myProfile.clickOnProfileButton();
	    myProfile.clickOnMyProfile();
	    myProfile.clickOnEditProfile();
	    myProfile.setFirstName("   ");
	    myProfile.setLastName(config.getLastName());
	    myProfile.clickOnSaveChanges();

	    Assert.assertEquals(myProfile.getFirstNameRequiredError(), "Firstname Required");
	    System.out.println("Test case 4: Validate whitespace-only First Name is not allowed");
	}

	
	@Test(groups = "regression") // Failure of the test case
	public void myProfileWithWhitespaceOnlyLastName() {
	    MyProfilePage myProfile = new MyProfilePage(driver);
	    myProfile.clickOnProfileButton();
	    myProfile.clickOnMyProfile();
	    myProfile.clickOnEditProfile();
	    myProfile.setFirstName(config.getFirstName());
	    myProfile.setLastName("   "); // Whitespace only
	    myProfile.clickOnSaveChanges();

	    Assert.assertEquals(myProfile.getLastNameRequiredError(), "Lastname Required");
	    System.out.println("Test case 5: Validate whitespace-only Last Name is not allowed");
	}

	
	@Test(groups = "regression") // Failure of the test case
	public void myProfileWithLongFirstName() {
	    MyProfilePage myProfile = new MyProfilePage(driver);
	    myProfile.clickOnProfileButton();
	    myProfile.clickOnMyProfile();
	    myProfile.clickOnEditProfile();
	    myProfile.setFirstName("ThisIsAReallyLongFirstNameThatKeepsGoingAndGoingAndMightBreakStuff");
	    myProfile.setLastName(config.getLastName());
	    myProfile.clickOnSaveChanges();

	    Assert.assertEquals(myProfile.getAlertMessage(), "Profile Updated Successfully");
	    System.out.println("Test case 5: Validate long names are accepted");
	}
	
	@Test(groups = "regression") // sucesss
	public void saveWithoutMakingAnyChanges() {
	    MyProfilePage myProfile = new MyProfilePage(driver);
	    myProfile.clickOnProfileButton();
	    myProfile.clickOnMyProfile();
	    myProfile.clickOnEditProfile();
	    
	    myProfile.clickOnSaveChanges(); // No changes made
	    
	    Assert.assertEquals(myProfile.getAlertMessage(), "Profile Updated Successfully");
	    System.out.println("Test case 7: Validate message when saving without changes");
	}
	
	@Test(groups = "regression")// sucesss
	public void backToProfile() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnMyProfile();
		myProfile.clickOnEditProfile();
		myProfile.clickOnBackToProfile();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/userProfile"));
		Assert.assertTrue(urlMatched, "Back to Profile failed: URL did not match");
		System.out.println("Test case 8: Validate message when going back to profile");
	}


	// UPDATE PASSWORD
	
	@Test(groups = "regression") //success of the test case
	public void updatePasswordWithEmptyCurrentPassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword("");
		myProfile.setNewPassword(config.getNewPassword());
		myProfile.setConfirmNewPassword(config.getConfirmPassword());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getPleaseEnterYourCurrentPasswordError(), "Please enter your current password");
		System.out.println("Test case 10 : Validate Current Password Required error message");
		
	}
	@Test(groups = "regression") // success of the test case
		public void updatePasswordWithEmptyNewPasswordAndEmptyConfirmPassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword("");
		myProfile.setConfirmNewPassword("");
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getPleaseEnterYourNewPasswordError(), "Please Enter Your New Password");
		Assert.assertEquals(myProfile.getPleaseConfirmYourNewPasswordError(), "Please Confirm Your New Password");
		System.out.println("Test case 11 : Validate New Password And Confirm Password Required error message");
		
	}
	
	@Test(groups = "regression") // success of the test case
	public void updatePasswordWithEmptyNewPasswordAndFillingConfirmPassword() { //empty confirm password
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword("");
		myProfile.setConfirmNewPassword(config.getConfirmPassword());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getPleaseEnterYourNewPasswordError(), "Please Enter Your New Password");
		Assert.assertEquals(myProfile.getTwoPasswordsDoNotMatchError(), "The two passwords that you entered do not match");
		System.out.println("Test case 12 : Validate Two Passwords do not match error message");
		
	}
	
	@Test(groups = "regression") //success of the test case
	public void updatePasswordWithEmptyConfirmPassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword(config.getNewPassword());
		myProfile.setConfirmNewPassword("");
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getPleaseConfirmYourNewPasswordError(), "Please Confirm Your New Password");
		System.out.println("Test case 12 : Validate Confirm Password Required error message");
		
	}
	@Test(groups = "regression") // success of the test case
	public void updatePasswordWithMismatchedNewAndConfirmPassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword(config.getNewPassword());
		myProfile.setConfirmNewPassword("DifferentConfirmPassword");
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getTwoPasswordsDoNotMatchError(), "The two passwords that you entered do not match");
		System.out.println("Test case 13 : Validate New Password and Confirm Password do not match error message");
		
	}
//	@Test(priority = 15) // failure of the test case in this it should fail
//	
//	public void updatePasswordWithShortNewPassword() {
//		MyProfilePage myProfile = new MyProfilePage(driver);
//		myProfile.clickOnProfileButton();
//		myProfile.clickOnChangePassword();
//		myProfile.setCurrentPassword(config.getPassword());
//		myProfile.setNewPassword("short");
//		myProfile.setConfirmNewPassword("short");
//		myProfile.clickOnSaveChanges();
//		
//		Assert.assertEquals(myProfile.getAlertMessage(), "New Password must be at least 8 characters long");
//		System.out.println("Test case 14 : Validate New Password must be at least 8 characters long error message");
//		
//	}
	
	@Test(groups = "regression") // success of the test case
	public void updatePasswordWithSameAsCurrentPassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword(config.getPassword());
		myProfile.setConfirmNewPassword(config.getPassword());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getAlertErrorMessage(), "New password must be different from the current password");
		System.out.println("Test case 15 : Validate New Password must be different from the current password error message");
		
	}
	
	@Test(groups = "regression") // success of the test case
	
	public void backAfterUpdatePassword() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.clickOnBack();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean urlMatched = wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/dashboard"));
		Assert.assertTrue(urlMatched, "Back to Profile failed: URL did not match");
		System.out.println("Test case 16 : Validate message when going back to profile after updating password");
		
	}
	
	@Test(groups = "regression") //success of the test case
	public void updatePasswordWithValidCrendentials() {
		MyProfilePage myProfile = new MyProfilePage(driver);
		myProfile.clickOnProfileButton();
		myProfile.clickOnChangePassword();
		myProfile.setCurrentPassword(config.getPassword());
		myProfile.setNewPassword(config.getNewPassword());
		myProfile.setConfirmNewPassword(config.getConfirmPassword());
		myProfile.clickOnSaveChanges();
		
		Assert.assertEquals(myProfile.getAlertMessage(), "Password updated successfully");
		System.out.println("Test case 9 : Validate Password updated successfully");
		
	}


}
