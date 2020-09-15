package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.OrderSummaryPage;

public class OrderSummaryPageSteps {
	TestContext testContext;
	OrderSummaryPage orderSummaryPage;
	
	public OrderSummaryPageSteps(TestContext context) {
		testContext = context;
		orderSummaryPage = testContext.getPageObjectManager().getOrderSummaryPage();
	}
	
	@Then("place order and pay")
	public void place_order_and_pay() throws InterruptedException {
		orderSummaryPage.completePurchase();
	}
	
}
