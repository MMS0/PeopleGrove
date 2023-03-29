package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Utilities.BrowserSetup;
import Utilities.Reports;
import functionalities.HomeFunctions;
import functionalities.InboxFunctions;
import functionalities.LoginFunctions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Assignment1 extends BrowserSetup{

	public Reports report;
	
	@Before
	public void startReports() {
		Reports.startReport();
	}
	@Given("Navigate to basecopy5 login page")
	public void navigate_to_basecopy5_login_page() throws IOException {
		launchbrowser();
	}

	@When("^Enter the email as (.*) and password as (.*)$")
	public void enter_the_email_test_peoplegrove_com_and_password_testing(String email, String password) throws IOException {
		PageFactory.initElements(driver, LoginFunctions.class); 
		LoginFunctions.setEmail(email);
		LoginFunctions.setPassword(password);	
	}

	@When("Click Login button and Verify the Home page")
	public void click_login_button_and_verify_the_home_page() throws IOException, InterruptedException {
		PageFactory.initElements(driver, LoginFunctions.class); 
		LoginFunctions.clickLogin();
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.verifyHomePage();
	}

	@When("Mouse over on Carrer and Click the Jobs")
	public void mouse_over_on_carrer_and_click_the_jobs() throws IOException, InterruptedException {
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.cickCareerJob();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	}

	@When("Select anyone of the Jobs")
	public void select_anyone_of_the_jobs() throws IOException, InterruptedException {
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.selectAnyJob();
	}
	@When("Click on Ask a Question button")
	public void clickAskQuestion() throws IOException, InterruptedException {
		//PageFactory.initElements(driver, HomeFunctions.class); 
		//HomeFunctions.clickAskQuestion();
		WebElement m=driver.findElement(By.xpath("//span[text()='Test User 8']/following::button[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", m);
	}

	@When("^Enter the required (.*) in Job Description and Click Send$")
	public void enter_the_required_Job_details_in_job_description_and_click_send(String details) throws IOException, InterruptedException {
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.enterJDInfo(details);
		
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.cickCareerJob();
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		HomePage.firstJob.click();
		//HomePage.typeMessageField.sendKeys("ManMohan Singh Jan 1,2023 and Total years of experience is 3");
	}

	@Then("Verify the Acknowledgement message")
	public void verify_the_acknowledgement_message() throws IOException, InterruptedException {
		PageFactory.initElements(driver, HomeFunctions.class); 
		HomeFunctions.verifyAcknowledgementMessage();
	}

	@Then("Click on the Keep the Convo Going button")
	public void click_on_the_keep_the_convo_going_button() throws IOException, InterruptedException {
		PageFactory.initElements(driver, HomeFunctions.class); 
		//HomeFunctions.clickKeepConvo();
		WebElement m=driver.findElement(By.xpath("//button[text()='Keep the Convo Going!']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", m);
	}

	@Then("Validate the sent info message is displayed in Inbox of the same user which is entered from Job description")
	public void validate_the_sent_info_message_is_displayed_in_inbox_of_the_same_user_which_is_entered_from_job_description() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.verifyInboxMessage();
	}

	@Then("Click on View Profile and Test User")
	public void click_on_view_profile_and_test_user() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.clickViewProfile();
		InboxFunctions.clickTestUser();
	}

	@When("Enable the Admin View-of")
	public void enable_the_admin_view_of() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.enableAdminViewOff();
	}

	@When("Click on Login As so it login as a Test User8")
	public void click_on_login_as_so_it_login_as_a_test_user8() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.clickLoginAs();
	}

	@When("Click on View Message")
	public void click_on_view_message() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.clickViewMessage();
	}

	@Then("Verify the info message should received to Test User8 which is sent by user")
	public void verify_the_info_message_should_received_to_test_user8_which_is_sent_by_user() throws IOException, InterruptedException {
		PageFactory.initElements(driver, InboxFunctions.class); 
		InboxFunctions.verifyReceivedMessage();
		screenshot("Assignment1");
		PageFactory.initElements(driver, HomeFunctions.class); 	
		Actions act=new Actions(driver);
		act.moveToElement(HomePage.profile).build().perform();
		HomePage.signOut.click();
		driver.close();
	}
	@After
	public void closeReports() {
		Reports.close();
	}

}
