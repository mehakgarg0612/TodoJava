package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass
{
			
		// logger.info("*****Starting TC_001_LoginTest******");
	
		@Test (priority = 1)
		public void validLoginTest() {
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(config.getEmail());
		lp.setPassword(config.getPassword());
		lp.clickLogin();
		
		String expected_url = "https://todolist.idsil.com/login";
		String actual_url = driver.getCurrentUrl();
		
		Assert.assertEquals(actual_url, expected_url , "Login failed url didn't find");
//		logger.info(*****Finished TC_001_LoginTest************);
		}
		
		
		// logger.info("*****Starting TC_001_LoginTest******");
		
		@Test (priority = 2)
		public void invalidLoginTest() {
			LoginPage lp = new LoginPage(driver);
			lp.setEmail("mehak@idsil.com");
			lp.setPassword("mehak");
			lp.clickLogin();
			
//			String actualMsg = lp.getErrorMessage();
//		    Assert.assertEquals(actualMsg, "Invalid email or password");
			
		}
		
	}

