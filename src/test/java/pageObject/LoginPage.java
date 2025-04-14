package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
	
	//Locators
    private WebDriver driver;
    private WebDriverWait wait;

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");

    private By emailFormatError = By.xpath("//div[text()='Invalid email format']");
    private By passwordRequiredError = By.xpath("//div[text()='Password is required']");
    private By emailRequiredError = By.xpath("//div[text()='Email is required']");
    private By userNotExistError = By.xpath("//span[contains(text(),'User does not exist')]");
    private By wrongPasswordError = By.xpath("//span[contains(text(),'Incorrect Password')]");



// Constructors
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

/**
 * it sets the value for username or email
 * @Input:- username
 * @param userEmail
 */
    
    
    //Actions
    public void setEmail(String userEmail) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(userEmail);
    }

    public void setPassword(String pwd) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(pwd);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public String getEmailFormatError(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailFormatError)).getText();
    }

    public String getPasswordRequiredError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordRequiredError)).getText();
    }

    public String getEmailRequiredError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(emailRequiredError)).getText();
    }

    public String getUserNotExistError(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(userNotExistError)).getText();
    }

    public String getWrongPasswordError() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(wrongPasswordError)).getText();
    }



}



