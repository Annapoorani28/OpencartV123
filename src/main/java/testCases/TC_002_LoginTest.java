package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass 
{
	
	@Test(groups= {"sanity", "master"})
	public void LoginTest()
	{
		try
		{
		logger.info("*******Starting Test TC_002_LoginTest*********");
		HomePage hp=new HomePage(driver);
		hp.clicklnkMyAccount();
		logger.info("clicked MyAccount");
		hp.clickLogin();
		logger.info("clicked Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(rb.getString("email"));
		logger.info("provided EmailAddress");
		lp.setPassword(rb.getString("password"));
		logger.info("provided password");
		lp.clickLogin();
		logger.info("login button clicked");
		
		MyAccountPage macc=new MyAccountPage(driver);
				{
		boolean targetpage=macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true);
				}
	}
		catch(Exception e)
		{
			Assert.fail();
			logger.info("test failed");
		}
		logger.info("******Finshed Test TC_002_LoginTest********");
	}

}
