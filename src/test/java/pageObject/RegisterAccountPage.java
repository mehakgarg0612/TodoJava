package pageObject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage {
	
	// Locators
    private WebDriver driver;
    private WebDriverWait wait;

    private final By FIRST_NAME = By.xpath("//input[@id='firstName' and @aria-required='true' and contains(@class, 'ant-input')]");
    private final By LAST_NAME = By.xpath("//div[contains(@class, 'ant-form-item-control-input-content')]//input[@id='lastName' and @aria-required='true' and contains(@class, 'ant-input')]");
    private final By EMAIL = By.xpath("//div[contains(@class, 'ant-form-item-control-input-content')]//input[@id='email' and @aria-required='true' and contains(@class, 'ant-input')]");
    private final By EMPLOYEE_CODE = By.xpath("//div[contains(@class, 'ant-form-item-control-input-content')]//input[@id='empCode' and @aria-required='true' and contains(@class, 'ant-input')]");
    private final By PASSWORD = By.xpath("//input[@id='password' and @aria-required='true' and @type='password' and contains(@class, 'ant-input')]");
    private final By CONFIRM_PASSWORD = By.xpath("//input[@id='confirmPassword' and @aria-required='true' and @type='password' and contains(@class, 'ant-input')]");
    private final By SUBMIT = By.xpath("//button[@type='submit' and contains(@class, 'ant-btn') and contains(@class, 'ant-btn-primary')]//span[text()='Submit']");
    
    private final By FIRST_NAME_REQUIRED_ERROR = By.xpath("//div[text()='First Name is required']");
    private final By LAST_NAME_REQUIRED_ERROR = By.xpath("//div[text()='Last Name is required']");
    private final By EMAIL_REQUIRED_ERROR = By.xpath("//div[text()='Email is required']");
     private final By EMPLOYEE_CODE_REQUIRED_ERROR = By.xpath("//div[text()='Employee Code is required']");
     private final By PASSWORD_REQUIRED_ERROR = By.xpath("//div[text()='Password is required']");
     private final By CONFIRM_PASSWORD_REQUIRED_ERROR = By.xpath("//div[text()='Please confirm your password']");
     

    // Constructor
    public RegisterAccountPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions
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
}

    

