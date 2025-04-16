package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyProfilePage {
	
    private WebDriver driver;
    private WebDriverWait wait;
    
    final By PROFILE_BUTTON = By.xpath("//div[@class ='ant-space css-txh9fw ant-space-horizontal ant-space-align-center hover:bg-gray-200 cursor-pointer p-2 uppercase ']");
	final By MY_PROFILE = By.xpath("//div[text()=' My Profile']");
	final By EDIT_PROFILE = By.xpath("//h1[@title='Edit Profile']");
	final By FIRST_NAME = By.xpath("//input[@id='firstName']");
	final By LAST_NAME = By.xpath("//input[@id='lastName']");
	final By SAVE_UPDATE_CHANGES = By.xpath("//button[@type='submit']");
	final By ALERT_MESSAGE = By.xpath("//div[@class='ant-message-custom-content ant-message-success']/span[2]");
	final By ALERT_ERROR_MESSAGE = By.xpath("//div[@class='ant-message-custom-content ant-message-error']/span[2]");
	
	final By FIRST_NAME_REQUIRED = By.xpath("//div[text()='Firstname Required']");
	final By LAST_NAME_REQUIRED = By.xpath("//div[text()='Lastname Required']");
	final By BACK_TO_PROFILE = By.xpath("//span[text()=' Back to Profile '] ");
	
	final By CHANGE_PASSWORD = By.xpath("//div[text()=' Change Password']");
	final By ENTER_YOUR_CURRENT_PASSWORD = By.xpath("//input[@placeholder='Enter Your Current Password']");
	final By ENTER_YOUR_NEW_PASSWORD = By.xpath("//input[@placeholder='Enter Your New Password']");
	final By CONFIRM_YOUR_NEW_PASSWORD = By.xpath("//input[@placeholder='Confirm Your New Password']");
	//final By SAVE_UPDATE_CHANGES = By.xpath("//button[@type='submit']"); // reusable method
	
	final By PLEASE_ENTER_YOUR_CURRENT_PASSWORD_ERROR = By.xpath("//div[text()='Please enter your current password']");
	final By PLEASE_ENTER_YOUR_NEW_PASSWORD_ERROR = By.xpath("//div[text()='Please Enter Your New Password']");
	final By PLEASE_CONFIRM_YOUR_NEW_PASSWORD_ERROR = By.xpath("//div[text()='Please Confirm Your New Password']");
	final By TWO_PASSWORDS_DO_NOT_MATCH_ERROR = By.xpath("//div[text()='The two passwords that you entered do not match']");
	final By BACK = By.xpath("//span[text()=' Back  ']");
	
	
	// Constructors
    public MyProfilePage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    
    //Actions
    
    public void clickOnBack() {	
    			wait.until(ExpectedConditions.elementToBeClickable(BACK)).click();
    }
    
    public String getTwoPasswordsDoNotMatchError() {
    		return wait.until(ExpectedConditions.visibilityOfElementLocated(TWO_PASSWORDS_DO_NOT_MATCH_ERROR)).getText();
    }
    public String getPleaseConfirmYourNewPasswordError() {
    			return wait.until(ExpectedConditions.visibilityOfElementLocated(PLEASE_CONFIRM_YOUR_NEW_PASSWORD_ERROR)).getText();
    }
    public String getPleaseEnterYourNewPasswordError() {	
				return wait.until(ExpectedConditions.visibilityOfElementLocated(PLEASE_ENTER_YOUR_NEW_PASSWORD_ERROR)).getText();
	}
    public String getPleaseEnterYourCurrentPasswordError() {	
    			return wait.until(ExpectedConditions.visibilityOfElementLocated(PLEASE_ENTER_YOUR_CURRENT_PASSWORD_ERROR)).getText();
    }
    
    
    public void setConfirmNewPassword(String confirmNewPassword) {
    			WebElement ConfirmNewPassword = wait.until(ExpectedConditions.elementToBeClickable(CONFIRM_YOUR_NEW_PASSWORD));
    			ConfirmNewPassword.click(); 
    			ConfirmNewPassword.sendKeys(confirmNewPassword);
    }
    
    public void setNewPassword(String newPassword) {
    			WebElement NewPassword = wait.until(ExpectedConditions.elementToBeClickable(ENTER_YOUR_NEW_PASSWORD));
    			NewPassword.click(); // Ensure focus
    			NewPassword.sendKeys(newPassword); 
     }
    
    public void setCurrentPassword(String currentPassword) {
		WebElement CurrentPassword = wait.until(ExpectedConditions.elementToBeClickable(ENTER_YOUR_CURRENT_PASSWORD));
		CurrentPassword.click(); // 
		CurrentPassword.sendKeys(currentPassword);
	}

    
    public void clickOnChangePassword() {
    	wait.until(ExpectedConditions.elementToBeClickable(CHANGE_PASSWORD)).click();
    }
    
    public void clickOnBackToProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(BACK_TO_PROFILE)).click();
	}
    
    public String getLastNameRequiredError() {
    		return wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_REQUIRED)).getText();
    }
    
    public String getFirstNameRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_REQUIRED)).getText();
	}
    
    public String getAlertErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_ERROR_MESSAGE)).getText();
	}
    
    public String getAlertMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(ALERT_MESSAGE)).getText();
    }

    public void clickOnSaveChanges() {
    	wait.until(ExpectedConditions.elementToBeClickable(SAVE_UPDATE_CHANGES)).click();
    }
    
    
    public void setLastName(String lastName) {
		WebElement LastName = wait.until(ExpectedConditions.elementToBeClickable(LAST_NAME));
		
		LastName.click(); // Ensure focus
		LastName.sendKeys(Keys.CONTROL + "a"); // Select all
		LastName.sendKeys(Keys.DELETE);        // Delete selected content
		LastName.sendKeys(lastName);
		
//		LastName.clear();
//		LastName.click();
//		LastName.sendKeys(lastName);
//    	
				//driver.findElement(LAST_NAME).clear();
				//driver.findElement(LAST_NAME).sendKeys(lastName);
		
	}
    
    public void setFirstName(String firstName) {
    	WebElement FirstName = wait.until(ExpectedConditions.elementToBeClickable(FIRST_NAME));
    	
    	FirstName.click(); // Ensure focus
        FirstName.sendKeys(Keys.CONTROL + "a"); // Select all
        FirstName.sendKeys(Keys.DELETE);        // Delete selected content
        FirstName.sendKeys(firstName);  
        
        
//    	driver.findElement(FIRST_NAME).clear();
//    	driver.findElement(FIRST_NAME).sendKeys(firstName);
        
//    	FirstName.clear();
//    	FirstName.click();
//    	FirstName.sendKeys(firstName);
//		
    }
    
   
    
    public void clickOnEditProfile() {
		wait.until(ExpectedConditions.elementToBeClickable(EDIT_PROFILE)).click();
	}
    public void clickOnMyProfile() {
    	wait.until(ExpectedConditions.elementToBeClickable(MY_PROFILE)).click();
    }
    
    public void clickOnProfileButton() {
		wait.until(ExpectedConditions.elementToBeClickable(PROFILE_BUTTON)).click();		
	}


}
