package functionalities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import PageObjects.LoginPage;

public class LoginFunctions extends LoginPage{
	
	//private WebDriver driver;
	
	//public LoginFunctions(WebDriver driver) {
		//this.driver=driver;
		//PageFactory.initElements(driver, LoginPage.class);
	//}
	
	public static void setEmail(String email) throws IOException {
		if(emailField.isDisplayed()&&emailField.isEnabled()) {
				emailField.clear();
				emailField.sendKeys(email);
				test.log(Status.PASS,"Entered the user email inside the displaying EmailId Field");			
				//getScreenShot(driver, "Screenshot_");
				//test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
				//test.addScreenCaptureFromPath("./Results/Screenshots/"+"screenshot_"+System.currentTimeMillis()+".png");
				//test.log(Status.PASS,test.addScreenCaptureFromPath("./Results/Screenshots")).build();//"./Results/Screenshots"));
		}
		else {
			test.log(Status.FAIL,"Email Id field is not Displayed");
		}
		
	}
	public static void setPassword(String password) throws IOException {
		if(passwordField.isDisplayed()&& passwordField.isEnabled()) {
		passwordField.clear();
		passwordField.sendKeys(password);
		test.log(Status.PASS,"Entered the user password inside the displaying Password Field");
		//getScreenShot(driver, "Screenshot_");
		//test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		}
		else {
			test.log(Status.FAIL,"Password field is not Displayed");
		}
	}
	public static void clickLogin() throws InterruptedException {
		if(loginButton.isDisplayed()&& loginButton.isEnabled()) {
			loginButton.click();
			test.log(Status.PASS,"Clicking on the displaying Login Button");
			Thread.sleep(10000);
			}
			else {
				test.log(Status.FAIL,"Login button is not Displayed");
			}
	}
}
