//package pageObject;
//
//import java.time.Duration;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//
//public class CalenderTesting {
//
//	WebDriver driver = new ChromeDriver();
//	driver.ge
//			 
//    driver.manage().deleteAllCookies();
//    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));      
//    driver.manage().window().maximize();
//	
//	final By START_DATE = By.xpath("//input[@id='startDate']");
//	final By CALENDER = By.xpath("//div[@class='ant-picker-header-view']");
//    final By MONTH = By.xpath("//div[@class='ant-picker-header-view']/button[@class='ant-picker-month-btn']");
//    final By YEAR = By.xpath("//div[@class='ant-picker-header-view']/button[@class='ant-picker-year-btn']");
//    final By DUE_DATE = By.xpath("//input[@id='endDate']");
//    
//    
//	public void enterStartDate(String startDate) {
//		WebElement startDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("startDate")));
//		startDateInput.clear(); 
//		startDateInput.click(); 
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-picker-body']//table[@class='ant-picker-content']")));
//		String monthYearValue = driver.findElement(By.xpath("ant-picker-header-view")).getText();
//}
