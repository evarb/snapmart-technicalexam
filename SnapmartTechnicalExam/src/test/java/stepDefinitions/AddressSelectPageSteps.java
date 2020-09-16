package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.AddressSelectPage;

public class AddressSelectPageSteps {
	TestContext testContext;
	AddressSelectPage addressSelectPage;
	
	public AddressSelectPageSteps(TestContext context) {
		testContext = context;
		addressSelectPage = testContext.getPageObjectManager().getAddressSelectPage();
	}
	
	@Then("select an address")
	public void select_an_address() throws InterruptedException {
		System.out.println("selecting address..");
		addressSelectPage.selectFirstAddress();
		addressSelectPage.proceedToPayment();
	}
}
