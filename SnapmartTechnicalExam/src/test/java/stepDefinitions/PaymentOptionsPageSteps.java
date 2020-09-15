package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.PaymentOptionsPage;

public class PaymentOptionsPageSteps {

	TestContext testContext;
	PaymentOptionsPage paymentOptionsPage;
	
	public PaymentOptionsPageSteps(TestContext context) {
		testContext = context;
		paymentOptionsPage = testContext.getPageObjectManager().getPaymentOptionsPage();
	}
	
	@Then("select payment card")
	public void select_payment_card() throws InterruptedException {
		paymentOptionsPage.selectPaymentCard();
		paymentOptionsPage.proceedToReviewOrder();	
	}
}
