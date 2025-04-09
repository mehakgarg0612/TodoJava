package Util;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utilities.ReadConfig;

public class BaseTest {

    protected WebDriver driver;
    protected Logger logger;
//    protected Properties p;
    protected ReadConfig config;

    @BeforeClass
    public void openApp() throws IOException {
        config = new ReadConfig();

        logger = LogManager.getLogger(this.getClass());
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        System.out.println("URL is: " + config.getAppURL());
        driver.get(config.getAppURL());
        driver.manage().window().maximize();

        logger.info("Application opened successfully");
    }

    @AfterClass
    public void closeApp() {
        driver.quit();
        logger.info("Browser closed");
    }
}
