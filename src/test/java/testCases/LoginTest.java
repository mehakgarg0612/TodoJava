package testCases;

import pageObject.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass
{

	
	public void verify_login() {
		
		// logger.info("*****Starting TC_002_LoginTest******");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(null);
		lp.setPassword(null);
		lp.clickLogin();
		
		
		
	}
}
