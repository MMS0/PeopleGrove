
@Assignment1
Feature: Complete the PeopleGrove Assignment1

@ValidAssignment1
Scenario Outline: Verify entered job description message thread

	Given Navigate to basecopy5 login page
	When Enter the email as <Email> and password as <Password>
	And Click Login button and Verify the Home page
	When Mouse over on Carrer and Click the Jobs
	And Select anyone of the Jobs
	When Click on Ask a Question button
	And Enter the required <Job details> in Job Description and Click Send 
	Then Verify the Acknowledgement message
	And Click on the Keep the Convo Going button
	Then Validate the sent info message is displayed in Inbox of the same user which is entered from Job description
	And Click on View Profile and Test User
  When  Enable the Admin View-of
  And Click on Login As so it login as a Test User8
  When Click on View Message
  Then Verify the info message should received to Test User8 which is sent by user
  
 Examples:
 | Email 									| Password 		| Job details 																					  		 |
 | test+7@peoplegrove.com | Testing@123 | ManMohan Singh Jan 1,2023 and Total years of experience is 3 |
 
 