package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage 
{
public AccountRegistrationPage(WebDriver driver)
{
 super(driver);	
}
@FindBy(name="firstname") WebElement txtFirstName;
@FindBy(name="lastname") WebElement txtlastname;
@FindBy(name="email") WebElement txtemail;
@FindBy(name="telephone") WebElement txttelephone;
@FindBy(name="password") WebElement txtpassword;
@FindBy(xpath="//input[@id='input-confirm']") WebElement txtconfirmpassword;
@FindBy(xpath="//input[@name='agree']")WebElement chckpolicy;
@FindBy(xpath="//input[@value='Continue']") WebElement btncontinue;
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;

public void setFirstName(String ftname)
{
	txtFirstName.sendKeys(ftname);
}
public void setLastName(String ltname)
{
	txtlastname.sendKeys(ltname);
}
public void setEmail(String email)
{
	txtemail.sendKeys(email);
}
public void setTelephone(String tel)
{
	txttelephone.sendKeys(tel);
}
public void setPassword(String pwd)
{
	txtpassword.sendKeys(pwd);
}
public void setConfirmPassword(String pwd)
{
	txtconfirmpassword.sendKeys(pwd);

}

public void setPrivacyPolicy() 
{
	chckpolicy.click();

}

public void clickContinue() 
{
	btncontinue.click();
}
public String getmsgConfirmation()
{
	try 
	{
		return msgConfirmation.getText();
	}
	catch(Exception e)
	{
		return e.getMessage();
	}
}
}
