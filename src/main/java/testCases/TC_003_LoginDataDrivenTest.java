package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDataDrivenTest extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class) //here we are mentioning data provider file name and path were it is present
  public void test_Loginddt(String email, String pwd, String exp)
  {
		logger.info("*******Starting Test TC_003_LoginDataDrivenTest*********");
		HomePage hp=new HomePage(driver);
		hp.clicklnkMyAccount();
		logger.info("clicked MyAccount");
		hp.clickLogin();
		logger.info("clicked Login");
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmailAddress(email);
		logger.info("provided EmailAddress");
		lp.setPassword(pwd);
		logger.info("provided password");
		lp.clickLogin();
		logger.info("login button clicked");
		
		MyAccountPage macc=new MyAccountPage(driver);
		boolean targetpage=macc.isMyAccountPageExists();
		
		if(exp.equals("Valid"))
		{
			if(targetpage==true)
			{
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(true);
			}
			else {Assert.assertTrue(false);}
		}
			if(exp.equals("Invalid"))
			{
				if(targetpage==true)
				{
				MyAccountPage myaccpage = new MyAccountPage(driver);
				myaccpage.clickLogout();
				Assert.assertTrue(false);
				}
				else {Assert.assertTrue(true);}
		
}
		
  }
}
