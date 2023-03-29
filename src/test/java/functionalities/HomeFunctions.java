package functionalities;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.Status;

import PageObjects.HomePage;
import Utilities.BrowserSetup;
import Utilities.Reports;

public class HomeFunctions extends HomePage {

	public static BrowserSetup setup;

	public static void verifyHomePage() throws IOException {
		String home = homeButton.getText();
		if (home.equalsIgnoreCase("Home")) {
			System.out.println("Navigated to the " + home + " page");
			test.log(Status.PASS, "Navigated to the " + home + " page");
			test.addScreenCaptureFromPath(
					"./Results/Screenshots/" + "screenshot_" + System.currentTimeMillis() + ".png");
		} else {
			test.log(Status.FAIL, "It is not navigated to Home page");
		}
	}

	public static void cickCareerJob() throws IOException, InterruptedException {
		if (careerButton.isDisplayed() && careerButton.isEnabled()) {
			careerButton.click();

			test.log(Status.PASS, "Clicking on the Carrer button");
			// careerJob.click();
			setup.waits(careerButton);
			// careerJob.sendKeys(Keys.ENTER);
			// careerJob.sendKeys(Keys.ARROW_DOWN);
			// careerJob.sendKeys(Keys.ARROW_UP);
			test.log(Status.PASS, "Clicking on the Jobs button");
			//getScreenShot(driver, "Screenshot_");
			//test.addScreenCaptureFromPath(".//Results//Screenshots//" + "Screenshot_" + ".png");
		} else {
			test.log(Status.FAIL, "Carrer button is not displayed so unble to clic on Career button");
		}
	}

	public static void selectAnyJob() throws IOException, InterruptedException {
		if (firstJob.isDisplayed() && firstJob.isEnabled()) {
			firstJob.click();
			test.log(Status.PASS, "Clicking on the FirstJob button");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "Jobs are not displayed so unble to click on Jobs");
		}
	}

	public static void clickAskQuestion() throws IOException, InterruptedException {
		BrowserSetup.driver.navigate().refresh(); 
		firstJob.click();
		Thread.sleep(5000);
		BrowserSetup.waits(askQuestion);
		if (askQuestion.isDisplayed() && askQuestion.isEnabled()) {
			WebElement m=driver.findElement(By.xpath("//span[text()='Test User 8']/following::button[1]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", m);
			//askQuestion.click();
			test.log(Status.PASS, "Clicking on the " + askQuestion.getText() + " button");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "Ask a Question button is not displayed so unble to clic on Ask a Question button");
		}
	}

	public static void enterJDInfo(String details) throws IOException, InterruptedException {
		//((JavascriptExecutor)driver).executeScript("window.scrollBy(0,100)");
		Thread.sleep(5000);
		BrowserSetup.waits(typeMessageField);
		if(typeMessageField.isDisplayed()) { 
		  //typeMessageField.clear();
		  typeMessageField.sendKeys(details);
		  sendButton.click(); 
		  System.out.println("Entering the " + details+ " job details in type a message field and then Clicking the Send button");
		  test.log(Status.PASS, "Entering the " + details+
		  " job details in type a message field and then Clicking the Send button"); 
		  }
		  else //if (typeMessageField.isDisplayed() && typeMessageField.isEnabled()) {
		  {
		 	test.log(Status.FAIL, "Type a message field is not displayed");
		}
		Thread.sleep(5000);
		BrowserSetup.driver.navigate().back();
		Thread.sleep(5000);
		
	}

	public static void verifyAcknowledgementMessage() throws IOException, InterruptedException {
		if (acknowledgeMessage.isDisplayed()) {
			String acknowledge = acknowledgeMessage.getText();
			test.log(Status.PASS, "Following is the acknowledgement message: " + acknowledge);
			//String inboxtext = inboxText.getText();
			BrowserSetup.properties();
			String ack = BrowserSetup.property.getProperty("confirmAck");
			if (ack.equalsIgnoreCase(acknowledge)) {
				test.log(Status.PASS, acknowledge + " info message is displayed in Test User8 which is sent by user");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		}
		}else {
			test.log(Status.FAIL, "Acknowledgement message is not displayed");
		}
		//driver.navigate().back();
		//firstJob.click();\
		Thread.sleep(10000);
		
	}

	public static void clickKeepConvo() throws IOException, InterruptedException {
		if (keepTheConvoButton.isDisplayed() && keepTheConvoButton.isEnabled()) {
			keepTheConvoButton.click();
			test.log(Status.PASS, "Clicking on the " + keepTheConvoButton.getText() + " buttonn");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "Keep the convo button is not displayed");
		}
	}
	public static void signOut() {
		signOut.click();
	}


}
