package util;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import pageObject.LoginPage;
import utilities.ReadConfig;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;
//    protected Properties p;
    protected ReadConfig config;
    
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @BeforeMethod
   
    public void openApp() throws IOException {
        config = new ReadConfig();
        logger = LogManager.getLogger(this.getClass());

        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        System.out.println("URL is: " + config.getAppURL());
        driver.get(config.getAppURL()); // <===== THIS LINE WAS MISSING

        logger.info("Application opened successfully and navigated to URL.");
    }

    
    @AfterMethod
    public void closeApp() {
        driver.quit();
        logger.info("Browser closed");
    }
    
    
    public void login() {
        LoginPage lp = new LoginPage(driver);
        lp.setEmail(config.getEmail());
        lp.setPassword(config.getPassword());
        lp.clickLogin();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/dashboard"));
        System.out.println("Login successful.");
    }
    
   

    // Get current system date as start date
    
//    public static String getStartDate() {
//        LocalDate today = LocalDate.now();
//        return formatter.format(today);
//    }

    // Get due date by adding days from config
    

//    public String getDueDate() {
//       int daysToAdd = Integer.parseInt(config.getDueDate());
//        LocalDate dueDate = LocalDate.now().plusDays(daysToAdd);
//        return formatter.format(dueDate);
//    }
    public String getDueDate() {
       int daysToAdd = Integer.parseInt(config.getDueDate());
        LocalDate dueDate = LocalDate.now().plusDays(daysToAdd);
        return formatter.format(dueDate);
    }


}
