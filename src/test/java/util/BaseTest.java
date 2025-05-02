package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
import org.testng.ITestResult;
import org.testng.annotations.*;

import pageObject.LoginPage;
import utilities.ReadConfig;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger logger;
    protected ReadConfig config;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // Get WebDriver for current thread
    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void openApp() throws IOException {
        config = new ReadConfig();
        logger = LogManager.getLogger(this.getClass());
      
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        // options.addArguments("--headless");

        WebDriver localDriver = new ChromeDriver(options);
        driver.set(localDriver);  // Set thread-local driver

        getDriver().manage().deleteAllCookies();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        getDriver().manage().window().maximize();

        System.out.println("URL is: " + config.getAppURL());
        getDriver().get(config.getAppURL());

        logger.info("Application opened successfully and navigated to URL.");
        // login();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();  // Clear thread-local variable
            logger.info("Browser closed");
        }
    }

    @AfterSuite
    public void afterSuite(ITestResult result) {
        // Close ExtentReports
        ExtentReportListener.getExtent().flush();
    }

    public void login() {
        LoginPage lp = new LoginPage(getDriver());
        lp.setEmail(config.getEmail());
        lp.setPassword(config.getPassword());
        lp.clickLogin();

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://todolist.idsil.com/dashboard"));
        System.out.println("Login successful.");
    }

    public String getDueDate() {
        int daysToAdd = Integer.parseInt(config.getDueDate());
        LocalDate dueDate = LocalDate.now().plusDays(daysToAdd);
        return formatter.format(dueDate);
    }
    
    public void updateConfigValue(String key, String newValue) {
        try {
            //String path = System.getProperty("user.dir") + "/ToDoListFramework_01/src/test/resources/config.properties";
            String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config.properties";
            FileInputStream fis = new FileInputStream(path);
            Properties props = new Properties();
            props.load(fis);
            fis.close();

            // Update the value
            props.setProperty(key, newValue);

            // Write back to the file
            FileOutputStream fos = new FileOutputStream(path);
            props.store(fos, "Updated " + key + " value");
            fos.close();

            System.out.println("Updated " + key + " in config.properties");

        } catch (IOException e) {
            System.out.println("Failed to update config key: " + key);
            e.printStackTrace();
        }
    }

}
