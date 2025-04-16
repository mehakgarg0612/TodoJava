package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortByPriorityPage {
	
	//Locator
	
		private WebDriver driver;
		private WebDriverWait wait;
		
	 	final By PROJECTS = By.xpath("//span[text()='Projects']");
		final By MY_PROJECTS = By.xpath("//span[text()='My Projects']");
		final By QA_SCRUM_MEETING = By.xpath("//div[@class='cursor-pointer']");
		
		final By SORT_BY_PRIORITY = By.xpath("//i[@class='ri-arrow-up-down-line']");
		
		//final By DESCENDING = By.xpath("//button[contains(@class, 'ml-2') and not(contains(@class, 'active')) and not(span)]");
		
		



//CONSTRUCTOR

public SortByPriorityPage(WebDriver driver){
	this.driver = driver;
	this.wait = new WebDriverWait(driver , Duration.ofSeconds(10));
}


// ACTIONS

public void clickOnProject() {
	wait.until(ExpectedConditions.elementToBeClickable(PROJECTS)).click();
}

public void clickOnMyProjects() {
	wait.until(ExpectedConditions.elementToBeClickable(MY_PROJECTS)).click();
}

public void clickOnDailyMeetingBox() {
	wait.until(ExpectedConditions.elementToBeClickable(QA_SCRUM_MEETING)).click();
}

public void sortPriority() {
	wait.until(ExpectedConditions.elementToBeClickable(SORT_BY_PRIORITY)).click();

}

 }