package managers;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressSelectPage;
import pageObjects.BasketPage;
import pageObjects.DeliveryMethodPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrderSummaryPage;
import pageObjects.PaymentOptionsPage;

public class PageObjectManager {

	private WebDriver driver;
	private AddressSelectPage addressSelectPage;
	private BasketPage basketPage;
	private DeliveryMethodPage deliveryMethodPage;
	private HomePage homePage;
	private LoginPage loginPage;
	private OrderSummaryPage orderSummaryPage;
	private PaymentOptionsPage paymentOptionsPage;
	
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public AddressSelectPage getAddressSelectPage() {
		return (addressSelectPage == null) ? addressSelectPage = new AddressSelectPage(driver): addressSelectPage;
	}

	public BasketPage getBasketPage() {
		return (basketPage == null) ? basketPage = new BasketPage(driver): basketPage;
	}

	public DeliveryMethodPage getDeliveryMethodPage() {
		return (deliveryMethodPage == null) ? deliveryMethodPage = new DeliveryMethodPage(driver): deliveryMethodPage;
	}

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver): homePage;
	}

	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver): loginPage;
	}
	
	public OrderSummaryPage getOrderSummaryPage() {
		return (orderSummaryPage == null) ? orderSummaryPage = new OrderSummaryPage(driver): orderSummaryPage;
	}
	
	public PaymentOptionsPage getPaymentOptionsPage() {
		return (paymentOptionsPage == null) ? paymentOptionsPage = new PaymentOptionsPage(driver): paymentOptionsPage;
	}


	

	
	
	
}
