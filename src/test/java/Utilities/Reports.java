package Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Reports {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static Date date=new Date();
	public static DateFormat df=new SimpleDateFormat("dd-MM-yyyy, HH-mm");
	
	//@Before
	public static void startReport()
	{
		htmlreport=new ExtentHtmlReporter("./Results/"+"ExtentReport_"+df.format(date)+".html");
		htmlreport.config().setReportName("PeopleGrove Test Script");
		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreport.config().setChartVisibilityOnOpen(true);
		htmlreport.config().setTheme(Theme.STANDARD);
		//htmlreport.config().setAutoCreateRelativePathMedia(true);
		//extent.setSystemInfo("Tester", "ManmohanSingh");
		extent=new ExtentReports();
		extent.attachReporter(htmlreport);
		test=extent.createTest("PeopleGrove Automation Test Scripts");
		test.log(Status.INFO,"Current Date and Time is: "+date);
		//recorder=new ATUTestRecorder("Recorder", "TestScriptVideo-"+ dateformat.format(date), true);
		//return name;
	}
	//@After
	public static void close() {
		extent.flush();
		//driver.quit();
		
	}
	public static void screenshot(String name) throws IOException 
	{
		File sc=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sc,new File("./Results/Screenshots/"+name+".png"));
	}
	public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Results/Screenshots/" + screenshotName + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		}
}
