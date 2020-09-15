package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.LoginPage;
import pageObjects.OrderSummaryPage;
import pageObjects.PaymentOptionsPage;
import pageObjects.AddressSelectPage;
import pageObjects.BasketPage;
import pageObjects.DeliveryMethodPage;
import pageObjects.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class Steps {
 WebDriver driver;
 AddressSelectPage addressSelectPage;
 BasketPage basketPage;
 DeliveryMethodPage deliveryMethodPage;
 HomePage homePage;
 LoginPage loginPage;
 OrderSummaryPage orderSummaryPage;
 PaymentOptionsPage paymentOptionsPage;
 PageObjectManager pageObjectManager;
 WebDriverManager webDriverManager;


	@Given("user is on Login page")
	public void user_is_on_Login_page() {
		webDriverManager = new WebDriverManager();
		System.out.println("navigating to login page...");
		driver = webDriverManager.getDriver();
	    pageObjectManager = new PageObjectManager(driver);
	    loginPage = pageObjectManager.getLoginPage();
	    loginPage.goToLoginPage();
	}
	
	@Then("input credentials to login page")
	public void input_credentials_to_login_page() {
		System.out.println("logging in...");
		loginPage.login();
	}

	@Then("user search for \"([^\"]*)\"$")
	public void user_search_for_(String item) throws InterruptedException {
		System.out.println(item);
		homePage = pageObjectManager.getHomePage();
		homePage.search(item);
	}

	@Then("add to basket the first item")
	public void add_to_basket_the_first_item() {
	    homePage.addToBasket();
	}

	@Then("checkout item from mini cart")
	public void checkout_item_from_mini_cart() throws InterruptedException {
	    homePage.goToShoppingCart();
	    basketPage = pageObjectManager.getBasketPage();
	    basketPage.addToBasket();
	}

	@Then("select an address and {string} delivery")
	public void select_an_address_and_delivery_speed(String speed) throws InterruptedException {
		addressSelectPage = pageObjectManager.getAddressSelectPage();
		addressSelectPage.selectFirstAddress();
		addressSelectPage.proceedToPayment();
		deliveryMethodPage = pageObjectManager.getDeliveryMethodPage();
		deliveryMethodPage.chooseDeliverySpeed(speed);
		deliveryMethodPage.continueToPayment();
	}

	@Then("select payment card")
	public void select_payment_card() throws InterruptedException {
		paymentOptionsPage = pageObjectManager.getPaymentOptionsPage();
		paymentOptionsPage.selectPaymentCard();
		paymentOptionsPage.proceedToReviewOrder();	
	}

	@Then("place order and pay")
	public void place_order_and_pay() throws InterruptedException {
		orderSummaryPage = pageObjectManager.getOrderSummaryPage();
		orderSummaryPage.completePurchase();
		driver.quit();
	}

	
	
}
