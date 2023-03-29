package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import Utilities.BrowserSetup;
import Utilities.Reports;

public class LoginPage extends Reports{

	//public static Reports report;
	//public LoginPage(WebDriver rdriver) {
		//this.driver=rdriver;
		//PageFactory.initElements(rdriver, this);
	//}
	
	@FindBy(how=How.XPATH,using="//*[contains(@id,'email') and @type='text']")
	public static WebElement emailField;
	@FindBy(xpath="//*[starts-with(@id,'password') and @type='password']")
	public static WebElement passwordField;
	@FindBy(xpath="//*[contains(@type,'submit')]")
	public static WebElement loginButton;
	
	@FindBy(xpath="//*[starts-with(text(),'Forgot')]")
	public static WebElement forgetPassword;
	@FindBy(xpath="//*[starts-with(@id,'email-error')]")
	public static WebElement emailErrorMessage;
	@FindBy(xpath="//*[starts-with(@class,'notification-content')]")
	public static WebElement passwordErrorMessage;
	
	
}
