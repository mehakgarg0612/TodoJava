package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties prop;

    public ReadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            System.out.println("Config file not found!" + e.getMessage());
        }
    }

    public String getAppURL() {
        return prop.getProperty("appUrl");
    }

    public String getEmail() {
        return prop.getProperty("email");
    }

    public String getPassword() {
        return prop.getProperty("pwd");
    }
}

