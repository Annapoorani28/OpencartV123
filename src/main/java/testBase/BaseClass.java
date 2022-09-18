package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	static public WebDriver driver;
	public Logger logger;
	public ResourceBundle rb; //import from java utils
	
	@BeforeClass(groups= {"sanity", "regression", "master"})
	@Parameters("browser")
	public void setup(String br)
	{
		rb=ResourceBundle.getBundle("config");//no need specify the path of the file simply mentioning file name isenough
		logger = LogManager.getLogger(this.getClass());// for Logger 
		
		if(br.equals("chrome") || br.equals(""))// simply if no don't the browser name
		{
		
	  WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
		
	  WebDriverManager.edgedriver().setup();
	 driver=new EdgeDriver();
		}
		else if(br.equals("firefox"))
		{
		
	  WebDriverManager.firefoxdriver().setup();
	 driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println("Invalid Input");
		}
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
	 //driver.get("http://localhost/opencart/upload/");
	 driver.get(rb.getString("appURL"));// using resource bundle we are accesing data from properties file
	driver.manage().window().maximize();
	}
	@AfterClass(groups= {"sanity", "regression", "master"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString() 
	{
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	return generatedString;
	}
	public String randomNumber()
	{
		String generatedNumber=RandomStringUtils.randomNumeric(10);
		return generatedNumber;
		
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// combination SimpleDateFormat predefined class from java and also date format
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;//TakeScreenShot is an interface here we are doing type casting
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);//outputType file is a method
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";//if test failed we store screenshot in this path
  //user.dir represents current project path
		try {
			FileUtils.copyFile(source, new File(destination));//FileUtils from common.io dependency
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
