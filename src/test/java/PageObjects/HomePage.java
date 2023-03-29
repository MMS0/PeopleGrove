package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.Reports;

public class HomePage extends Reports{

	@FindBy(xpath="//*[contains(@aria-label,'Home')]")
	public static WebElement homeButton;
	@FindBy(xpath="//*[contains(@aria-label,'Career') and text()]")//*[starts-with(@aria-label,'Career')]
	public static WebElement careerButton;
	@FindBy(xpath="(//*[starts-with(@d,'M201.4')])[1]")
	public static WebElement careerJob;
	@FindBy(xpath="//*[starts-with(@d,'M201.4')]")
	public static WebElement careerList;
	
	@FindBy(xpath="(//*[starts-with(@class,'ant-card-body')])[1]")
	public static WebElement firstJob;
	
	@FindBy(xpath="//span[text()='Test User 8']/following::button[1]")
	public static WebElement askQuestion;
	
	@FindBy(xpath="//span[contains(text(),'Type your')]/preceding::div[1]")
	//span[contains(text(),'Type your message here')]")//*[starts-with(@class,'fr-element fr-view')]")
	public static WebElement typeMessageField;
	@FindBy(xpath="//span[contains(text(),'Send')]")//*[starts-with(text(),'Send')]")
	public static WebElement sendButton;
	@FindBy (xpath="//p[contains(text(),'get an')]")
	//(//p[contains(text(),'ManMohan Singh Jan ')])[2]")
	public static WebElement acknowledgeMessage;
	@FindBy(xpath="//button[text()='Keep the Convo Going!']")//*[starts-with(text(),'Keep the Convo')]")
	public static WebElement keepTheConvoButton;
	@FindBy(xpath="(//*[starts-with(text(),'Test User 8')])[21]")
	public static WebElement testUser8_Job;
	@FindBy(xpath="//*[starts-with(text(),'Login')]")
	public static WebElement loginAsButton;

	
	
	@FindBy(xpath="//*[contains(@aria-label,'Profile')]")
	public static WebElement profile;
	@FindBy(xpath="//*[starts-with(@role,'menu')]//following::li[7]")
	public static WebElement signOut;
}
