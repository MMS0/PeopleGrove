package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.automation.remarks.video.recorder.VideoRecorder;
import com.aventstack.extentreports.Status;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class BrowserSetup extends Reports
{

	public static WebDriver driver;
	public static Properties property;
	public static WebDriverWait wait;
	public static VideoRecorder record;
	public static Date date=new Date();
	public static DateFormat df=new SimpleDateFormat("dd-MM-yy, HH-mm");
	
	public static Properties properties() throws IOException
	{
		FileInputStream data=new FileInputStream("./src/test/resources/Data.properties");
		property=new Properties();
		property.load(data);
		return property;
	}
	
	//@Before(order=1)
	public static void launchbrowser() throws IOException
	{
		//recorder();
		properties();
		String title=property.getProperty("title");
		String browsername=property.getProperty("browser");
		String url = property.getProperty("url");
		String chrome=property.getProperty("cd");
		String firefox=property.getProperty("fd");
		String opera=property.getProperty("od");
		String edge=property.getProperty("ed");
		
		//Following commented lines are for get the set the browser for runtime by user
		
		//System.out.println("Please choose and enter anyone of the Browser name from the following list:"
		//+"\n 1. Chrome"+"\n 2. Firefox"+"\n 3. Edge"+"\n 4. Opera");
		//Scanner run=new Scanner(System.in);
		//String browser=run.next();
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",chrome);
			driver= new ChromeDriver();
			System.out.println("User had entered the Chrome browser so the PeopleGrove base5 application is launching in Chrome browser");
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",firefox);
			driver= new FirefoxDriver();
			System.out.println("User had entered the Firefox browser so the PeopleGrove base5 application is launching in Firefox browser");
		}
		else if(browsername.equalsIgnoreCase("opera"))
		{
			System.setProperty("webdriver.opera.driver",opera);
			driver= new OperaDriver();
			System.out.println("User had entered the Opera browser so the PeopleGrove base5 application is launching in Opera browser");
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver",edge);
			driver= new EdgeDriver();
			System.out.println("User had entered the Edge browser so the PeopleGrove base5 application is launching in Edge browser");
		}
		else
		{
			System.setProperty("webdriver.chrome.driver",chrome);
			driver= new ChromeDriver();
			System.out.println("User had entered wrong Browser name so that the PeopleGrove base5 application is launching in Chrome browser by Default");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.navigate().to(url);
		test.log(Status.PASS,"Navigate to basecopy5 login page");
		String actualtitle=driver.getTitle();
		System.out.println("Navigaed to the "+actualtitle+" page");
		//Assert.assertEquals(title, actualtitle);
		//System.out.println("Title Verified Successfully and the WebPage Title is: "+actualtitle);
	}
	//@After(order=0)
	public static void closeBrowser() 
	{
		driver.quit();
		//record.stopAndSave(".//Results//Records//"+"Test_"+df.format(date)+".mp4");
	}
	public static VideoRecorder recorder() {
		record.start();
		return record;
	}
	public static void waits(WebElement element) {
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		//return element;
	}
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "./Results/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
	public static void screenshot(String name) throws IOException 
	{
		File sc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sc,new File("./Results/Screenshots/"+name+".png"));
	}
	
}
