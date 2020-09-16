package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import pageObjects.HomePage;

public class HomePageSteps {

	TestContext testContext;
	HomePage homePage;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Then("user search for \"([^\"]*)\"$")
	public void user_search_for_(String item) throws InterruptedException {
		System.out.println("searching for " + item);
		homePage.search(item);
	}

	@Then("add to basket the first item")
	public void add_to_basket_the_first_item() {
		System.out.println("adding item on basket..");
	    homePage.addToBasket();
	}

	@Then("go to mini cart")
	public void go_to_mini_cart() throws InterruptedException {
		System.out.println("navigating to cart..");
	    homePage.goToShoppingCart();
	}
	
}
