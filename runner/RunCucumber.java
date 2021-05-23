package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun = false,
		
		features = {"src/test/java/Feature/DeleteLead.feature"},
		glue = {"stepdefs"},
		monochrome=true
		
		)

public class RunCucumber extends AbstractTestNGCucumberTests {


}
