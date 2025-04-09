package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    WebDriver driver;

    public  DashboardPage(WebDriver driver){
        this.driver = driver;

    }

    By greetingMessage = By.xpath("//div[text()='Hello, ']");
    By taskCount = By.xpath("//div[text()='TASK COUNT']/following-sibling::div");

    By projectCount = By.xpath("//div[text()='PROJECT COUNT']/following-sibling::div");
    By completedTaskBar = By.xpath("")
    By logoutButton = By.xpath("")

}
