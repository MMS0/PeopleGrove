package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Reports;

public class InboxPage extends Reports{

	@FindBy(xpath="(//*[starts-with(text(),'Inbox')])[1]")
	public static WebElement inboxText;
	@FindBy(xpath="//*[starts-with(@class,'rich-text ql-editor')]")
	public static WebElement inboxMessage;
	@FindBy(xpath="//p[contains(text(),'Test User')]//following::button[1]")//span[text()='View Profile']")
	public static WebElement viewProfileButton;
	@FindBy(xpath="//h3[text()='Test User 8']")//(//*[starts-with(text(),'Test User 8')])[31]")
	public static WebElement testUser8_Inbox;
	@FindBy(xpath="//h3[text()='Test User 8']")//h3[starts-with(text(),'Test User 8')]")
	public static WebElement testUser8_button;
	@FindBy(xpath="(//*[starts-with(@role,'switch')])[1]")
	public static WebElement adminViewOff;
	@FindBy(xpath="//span[text()='Email']//following::button[1]")//*[starts-with(text(),'Login')]")
	public static WebElement loginAsButton;

	@FindBy(xpath="//*[starts-with(text(),'View Mess')]")
	public static WebElement viewMessage;
	@FindBy(xpath="(//*[starts-with(text(),'MMS')])[4]")
	public static WebElement receivedMessage;

}
