package stepDefinitions;

import java.lang.module.FindException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;
import pageObjects.PaymentOptionsPage;
import pageObjects.AddressSelectPage;
import pageObjects.BasketPage;
import pageObjects.DeliveryMethodPage;
import pageObjects.HomePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Steps {
WebDriver driver;

	@Given("user is on Login page")
	public void user_is_on_Login_page() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Evan\\OneDrive\\Documents\\snapmart_technicalExam\\SnapmartTechnicalExam\\driver\\chromedriver.exe");
	    System.out.println("navigating to login page...");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    LoginPage loginPage = new LoginPage(driver);
	    loginPage.goToLoginPage();
	}
	
	@Then("input credentials to login page")
	public void input_credentials_to_login_page() {
		System.out.println("logging in...");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login();
	}

	@Then("user search for \"([^\"]*)\"$")
	public void user_search_for_(String item) throws InterruptedException {
		System.out.println(item);
		HomePage homePage = new HomePage(driver);
		homePage.search(item);
	}

	@Then("add to basket the first item")
	public void add_to_basket_the_first_item() {
		HomePage homePage = new HomePage(driver);
	    homePage.addToBasket();
	}

	@Then("checkout item from mini cart")
	public void checkout_item_from_mini_cart() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
	    homePage.goToShoppingCart();
	    
	    BasketPage basketPage = new BasketPage(driver);
	    basketPage.addToBasket();
	}

	@Then("select an address and {string} delivery")
	public void select_an_address_and_delivery_speed(String speed) throws InterruptedException {
		AddressSelectPage addressSelect = new AddressSelectPage(driver);
		addressSelect.selectFirstAddress();
		addressSelect.proceedToPayment();
		
		DeliveryMethodPage deliveryMethod = new DeliveryMethodPage(driver);
		deliveryMethod.chooseDeliverySpeed(speed);
		deliveryMethod.continueToPayment();
	}

	@Then("select payment card")
	public void select_payment_card() throws InterruptedException {
		PaymentOptionsPage paymentOptions = new PaymentOptionsPage(driver);
		paymentOptions.selectPaymentCard();
		paymentOptions.proceedToReviewOrder();	
	}

	@Then("place order and pay")
	public void place_order_and_pay() {
		driver.findElement(By.xpath("//button[@aria-label='Complete your purchase']")).click();
	}

	
	
}
