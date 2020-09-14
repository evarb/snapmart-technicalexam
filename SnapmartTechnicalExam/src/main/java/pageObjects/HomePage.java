package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;

@FindBy(xpath = "//mat-icon[text()=' search ']")
private WebElement searchIcon;

@FindBy(xpath = "//input")
private WebElement searchBar;

@FindBy(xpath = "//span[text()='Add to Basket']")
private WebElement addToBasketBtn;

@FindBy(xpath = "//mat-icon[text()=' shopping_cart ']")
private WebElement shoppingCartBtn;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void search(String item) throws InterruptedException {
		searchIcon.click();
		searchBar.sendKeys(item);
		Thread.sleep(2000);
		searchBar.sendKeys(Keys.RETURN);
	}
	
	public void addToBasket() {
		addToBasketBtn.click();
	}
	
	public void goToShoppingCart() throws InterruptedException {
		Thread.sleep(2000);
		shoppingCartBtn.click();
	}
		
}
