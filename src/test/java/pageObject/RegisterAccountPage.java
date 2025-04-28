package pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage {
	
	// Locators
    private WebDriver driver;
    private WebDriverWait wait;
    private final By REGISTER_ACCOUNT = By.xpath("//a[text()='Register']");

    private final By FIRST_NAME = By.xpath("//input[@id='firstName']");
    private final By LAST_NAME = By.xpath("//input[@id='lastName']");
    private final By EMAIL = By.xpath("//input[@id='email']");
    private final By EMPLOYEE_CODE = By.xpath("//input[@id='empCode']");
    private final By PASSWORD = By.xpath("//input[@id='password']");
    private final By CONFIRM_PASSWORD = By.xpath("//input[@id='confirmPassword']");
    private final By SUBMIT = By.xpath("//button[@type='submit']");
    private final By SUCCESSFUL_REGISTRATION_MESSAGE = By.xpath("//div[@class='ant-message-custom-content ant-message-success']//span[2]");
    private final By FIRST_NAME_REQUIRED_ERROR = By.xpath("//div[text()='First Name is required']");
    private final By LAST_NAME_REQUIRED_ERROR = By.xpath("//div[text()='Last Name is required']");
    private final By EMAIL_REQUIRED_ERROR = By.xpath("//div[text()='Email is required']");
     private final By EMPLOYEE_CODE_REQUIRED_ERROR = By.xpath("//div[text()='Employee Code is required']");
     private final By PASSWORD_REQUIRED_ERROR = By.xpath("//div[text()='Password is required']");
     private final By CONFIRM_PASSWORD_REQUIRED_ERROR = By.xpath("//div[text()='Please confirm your password']");
     private final By PASSWORD_MISMATCH_ERROR = By.xpath("//div[text()='The passwords do not match']");
     private final By INVALID_EMAIL_FORMAT_ERROR = By.xpath("//div[text()='Invalid email format']");
     private final By EMAIL_ALREADY_REGISTERED_ERROR = By.xpath("//div[@class='ant-message-custom-content ant-message-error']//span[2]");
     

    // Constructor
    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
    
    public String getEmailAlreadyRegisteredError() {
    			return wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_ALREADY_REGISTERED_ERROR)).getText();
    }
    
    public String getInvalidEmailFormatError() {
    			return wait.until(ExpectedConditions.visibilityOfElementLocated(INVALID_EMAIL_FORMAT_ERROR)).getText();
    }
    
    public String getPasswordMismatchError() {
    			return wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_MISMATCH_ERROR)).getText();
    }
    public String getSuccessfulRegistrationMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(SUCCESSFUL_REGISTRATION_MESSAGE)).getText();
	}
    
    public void clickRegisterAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(REGISTER_ACCOUNT)).click();
	}
    	
    public void enterFirstName(String firstName) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(LAST_NAME).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(EMAIL).sendKeys(email);
    }

    public void enterEmployeeCode(String employeeCode) {
        driver.findElement(EMPLOYEE_CODE).sendKeys(employeeCode);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        driver.findElement(CONFIRM_PASSWORD).sendKeys(confirmPassword);
    }

    public void clickSubmit() {
        driver.findElement(SUBMIT).click();
    }
    
    public String getFirstNameRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME_REQUIRED_ERROR)).getText();
	}
    
    public String getLastNameRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME_REQUIRED_ERROR)).getText();
	}
	
	public String getEmailRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_REQUIRED_ERROR)).getText();
	}
	
	public String getEmployeeCodeRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(EMPLOYEE_CODE_REQUIRED_ERROR)).getText();
	}
	
	public String getPasswordRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_REQUIRED_ERROR)).getText();
	}
	
	public String getConfirmPasswordRequiredError() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM_PASSWORD_REQUIRED_ERROR)).getText();
	}
	
	
}

    

