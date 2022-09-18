package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistration extends BaseClass
{
	
	@Test(groups= { "regression", "master"})
	public void AccountRegistration()
	{
		logger.info(" ******Started Testing*****");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clicklnkMyAccount();
		logger.info("clicked My account");
		hp.clickRegister();
		logger.info("Clicked My Register");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		logger.info("Provided firstname");
		regpage.setLastName(randomString().toUpperCase());
		logger.info("Provided lastname");
		regpage.setEmail(randomString()+"@gmail.com");
		logger.info("Provided email");
		regpage.setTelephone(randomNumber());
		logger.info("Provided telephone number");
		regpage.setPassword("test@123");
		logger.info("Provided password");
		regpage.setConfirmPassword("test@123");//intention failing test to test screenshot
		logger.info("Provided confirm password");
		regpage.setPrivacyPolicy();
		logger.info("clicked privacypolicy");
		regpage.clickContinue();
		logger.info("clicked continue");
		String confmsg=regpage.getmsgConfirmation();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		logger.info("****Test Ended*****");
	}
	catch(Exception e)
	{
		Assert.fail();
	}
		
	}
	
}
