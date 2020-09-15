package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pageObjects.LoginPage;

public class LoginPageSteps {

	TestContext testContext;
	LoginPage loginPage;
	
	public LoginPageSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().getLoginPage();
	} 
	
	@Given("user is on Login page")
	public void user_is_on_Login_page() {
		System.out.println("navigating to login page...");
	    loginPage.goToLoginPage();
	}
	
	@Then("input credentials to login page")
	public void input_credentials_to_login_page() {
		System.out.println("logging in...");
		loginPage.login();
	}
	
}
