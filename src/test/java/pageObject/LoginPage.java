package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	
    private WebDriver driver;

    private By email = By.id("email");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    
    
    

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail(String userEmail) {
        driver.findElement(email).sendKeys(userEmail);
    }

    public void setPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}



