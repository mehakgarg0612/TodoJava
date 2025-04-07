package testCases;

import pageObject.LoginPage;
import testBase.BaseClass;

public class LoginTest extends BaseClass
{

	
	public void verify_login() {
		
		// logger.info("*****Starting TC_002_LoginTest******");
		
		
		//Login page
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("pwd");
		lp.clickLogin();
		
		
		
	}
}
