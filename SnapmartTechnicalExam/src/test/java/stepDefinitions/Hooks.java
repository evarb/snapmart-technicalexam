package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	TestContext testContext;
	WebDriver driver;
	
	public Hooks(TestContext context) {
		testContext = context;
		
	}

	@Before
	public void SetUp() {
		
	}
	
	@After
	public void TearDown(Scenario scenario) {
		System.out.println("teardown...");
		//use this condition to limit screenshot for failed scenarios only
		//if(scenario.isFailed()) { 
			scenario.write("Current Page URL is " + testContext.getWebDriverManager().getDriver().getCurrentUrl());
			byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		//}
			
		testContext.getWebDriverManager().closeDriver();

	}
	
}



