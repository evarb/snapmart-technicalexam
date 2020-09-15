package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.BasketPage;

public class BasketPageSteps {

	TestContext testContext;
	BasketPage basketPage;
	
	public BasketPageSteps(TestContext context) {
		testContext = context;
		basketPage = testContext.getPageObjectManager().getBasketPage();
	}
	
	@Then("checkout item from basket")
	public void checkout_item_from_basket() throws InterruptedException {
	    basketPage.addToBasket();
	}
	
}
