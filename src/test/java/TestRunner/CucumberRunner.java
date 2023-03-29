package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
	(
		features=".//src//test//resources//Features//Assignment1_JobsInbox.feature", 
		glue="StepDefinition", 
		dryRun= false, monochrome = true, 
		//tags= "@Assignment1", 
		plugin={"pretty","html:test-output"}
	)
//{"html:Report//AutomationReport.html"}
public class CucumberRunner {

}
