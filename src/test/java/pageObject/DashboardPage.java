package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage  {
	
	 	 private WebDriver driver;
	 	 private WebDriverWait wait;

	   
	    //locators
	    
	    By greetingMessage = By.xpath("//div[starts-with(text(),'Hello')]");
	    By taskCount = By.xpath("//div[text()='TASK COUNT']/following-sibling::div//span[@class='ant-statistic-content-value-int']");
	    By projectCount = By.xpath("//div[text()='PROJECT COUNT']/following-sibling::div//span[@class='ant-statistic-content-value-int']");
	    
	    By completedTaskBar = By.xpath("//*[name()='tspan' and text()='Completed']");
	    By progessTaskBar = By.xpath("//*[name()='tspan' and text()='In Progress']");
	    By pendingTaskBar = By.xpath("//*[name()='tspan' and text()='Pending']");
	   
	    
	    //Constructor
	    
	    public DashboardPage(WebDriver driver) {
	    	this.driver = driver;
	    	this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    	
	    }
	    
	    //Actions
	    
	    public String getGreetingMessage() {
	    	return driver.findElement(greetingMessage).getText();
	    }
	    
	    public String getTaskCount() {
	    	return driver.findElement(taskCount).getText();
	    }
	    
	    public String getProjectCount() {
	    	return driver.findElement(projectCount).getText();
	    }
	    
	    public boolean isCompletedTasksVisible() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(completedTaskBar)).isDisplayed();
	    }
	    
	    public boolean isProgessTaskbarVisible() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(progessTaskBar)).isDisplayed();
	    }
	    
	    public boolean isPendingTaskbarVisible() {
	    	return wait.until(ExpectedConditions.visibilityOfElementLocated(pendingTaskBar)).isDisplayed();
	    }

}
