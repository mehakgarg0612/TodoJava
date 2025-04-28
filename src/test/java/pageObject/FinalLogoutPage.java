package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FinalLogoutPage {
		private WebDriver driver;
	private WebDriverWait wait;

	private By profileMenu = By.xpath("//div[contains(@class,'ant-space css-txh9fw')]");
	private By logoutButton = By.xpath("//li[@class='ant-dropdown-menu-item ant-dropdown-menu-item-only-child' and .//i[contains(@class,'ri-logout-circle-line')]]");

	public FinalLogoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	
	//Actions
	
	public void clickOnProfileMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
	}
	
	public void clickOnLogoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
	}

}
