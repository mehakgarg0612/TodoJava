package baseTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfig;

public class Base {

	public WebDriver driver;
	public ReadConfig config = new ReadConfig();
	
	
	@BeforeClass
	public void openApp() {
		
		driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

      driver.get(config.getAppURL());
      driver.manage().window().maximize();
	}
	
	@AfterClass
	
	public void closeApp() {
		driver.quit();
	}
}
