package functionalities;

import java.io.IOException;

import com.aventstack.extentreports.Status;

import PageObjects.InboxPage;
import Utilities.BrowserSetup;

public class InboxFunctions extends InboxPage {

	public BrowserSetup run;

	public static void verifyInboxMessage() throws IOException, InterruptedException {
		if (inboxText.isDisplayed() && inboxMessage.isDisplayed()) {
			String inboxmsg = inboxMessage.getText();
			String inboxtext = inboxText.getText();
			BrowserSetup.properties();
			String JDtext = BrowserSetup.property.getProperty("JD_Details");
			if (JDtext.equalsIgnoreCase(inboxmsg)) {
				test.log(Status.PASS, inboxmsg + " info message is displayed in" + inboxtext
						+ " of the same user which is entered from Job description");
				//getScreenShot(driver, "Screenshot_");
				// test.addScreenCaptureFromPath(".//Results//Screenshots//" + "Screenshot_" +
				// ".png");
			} else {
				test.log(Status.FAIL, "JD info message is not displayed in Inbox of the same user");
			}
		}
	}
	public static void clickViewProfile() throws IOException, InterruptedException {
		if (viewProfileButton.isDisplayed() && viewProfileButton.isEnabled()) {
			viewProfileButton.click();
			test.log(Status.PASS, "Clicking on the " + viewProfileButton.getText() + " button");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "View Profile button is not displayed");
		}
	}
	public static void clickTestUser() throws IOException, InterruptedException {
		if (testUser8_Inbox.isDisplayed()&& testUser8_button.isDisplayed() && testUser8_button.isEnabled()) {
			testUser8_button.click();
			test.log(Status.PASS, "Clicking on the " + viewProfileButton.getText() + " button and also navigated in following user: "+testUser8_Inbox.getText());
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "Test User button is not displayed");
		}
	}
	public static void enableAdminViewOff() throws IOException, InterruptedException {
		if (adminViewOff.isDisplayed() && adminViewOff.isEnabled()) {
			adminViewOff.click();
			test.log(Status.PASS, "Clicking on the " + adminViewOff.getText() + " button");
			// getScreenShot(driver, "Screenshot_");
			// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
		} else {
			test.log(Status.FAIL, "Admin View Off button is not displayed");
		}
	}
		public static void clickLoginAs() throws IOException, InterruptedException {
			if (loginAsButton.isDisplayed() && loginAsButton.isEnabled()) {
				loginAsButton.click();
				test.log(Status.PASS, "Clicking on the " + loginAsButton.getText() + " button");
				// getScreenShot(driver, "Screenshot_");
				// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
			} else {
				test.log(Status.FAIL, "Login As button is not displayed");
			}
		}
		public static void clickViewMessage() throws IOException, InterruptedException {
			if (viewMessage.isDisplayed() && viewMessage.isEnabled()) {
				viewMessage.click();
				test.log(Status.PASS, "Clicking on the " + viewMessage.getText() + " button");
				// getScreenShot(driver, "Screenshot_");
				// test.addScreenCaptureFromPath(".//Results//Screenshots//"+"Screenshot_"+".png");
			} else {
				test.log(Status.FAIL, "View Message button is not displayed");
			}
		}
		public static void verifyReceivedMessage() throws IOException, InterruptedException {
			if (receivedMessage.isDisplayed()) {
				String inboxmsg = receivedMessage.getText();
				//String inboxtext = inboxText.getText();
				BrowserSetup.properties();
				String JDtext = BrowserSetup.property.getProperty("JD_Details");
				if (JDtext.equalsIgnoreCase(inboxmsg)) {
					test.log(Status.PASS, inboxmsg + " info message is displayed in Test User8 which is sent by user");
					getScreenShot(driver, "Screenshot_");
					// test.addScreenCaptureFromPath(".//Results//Screenshots//" + "Screenshot_" +
					// ".png");
				} else {
					test.log(Status.FAIL, "JD info message is not displayed in Test User8 which is sent by user");
				}
			}
		}
		
}
