package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.DeliveryMethodPage;

public class DeliveryMethodPageSteps {

	TestContext testContext;
	DeliveryMethodPage deliveryMethodPage;
	
	public DeliveryMethodPageSteps(TestContext context) {
		testContext = context;
		deliveryMethodPage = testContext.getPageObjectManager().getDeliveryMethodPage();
	}
	
	@Then("select {string} delivery")
	public void select_delivery_speed(String speed) throws InterruptedException {
		deliveryMethodPage.chooseDeliverySpeed(speed);
		deliveryMethodPage.continueToPayment();
	}
}
