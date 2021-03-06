package runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		monochrome = true,
		plugin = { "pretty", "html:target/cucumber-reports" },
		junit = "--step-notifications"
		
)

public class SnapmartTest {
	
}