package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {
WebDriver driver;

@FindBy(id = "checkoutButton")
private WebElement checkOutBtn;

	
	public BasketPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addToBasket() throws InterruptedException {
		Thread.sleep(2000);
		checkOutBtn.click();
	}
		
}
