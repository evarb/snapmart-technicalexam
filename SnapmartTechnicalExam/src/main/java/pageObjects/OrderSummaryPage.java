package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
WebDriver driver;

@FindBy(xpath = "//button[@aria-label='Complete your purchase']")
private WebElement completePurchaseBtn;


	public OrderSummaryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void completePurchase() throws InterruptedException {
		Thread.sleep(2000);
		completePurchaseBtn.click();
	}
}

