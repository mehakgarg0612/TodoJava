package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(id = "email")
	WebElement LoginemailAddress;
	
	@FindBy(id = "password")
	WebElement Loginpassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement login;
	
	
	public void setEmail(String email) {
		LoginemailAddress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		Loginpassword.sendKeys(password);
	}
	
	public void clickLogin() {
		login.click();
	}
	
}



