package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressSelectPage {
WebDriver driver;

@FindBy(xpath = "(//mat-cell)[1]")
private WebElement firstAddress;

@FindBy(xpath = "//button[@aria-label='Proceed to payment selection']")
private WebElement proceedToPaymentBtn;



	public AddressSelectPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFirstAddress() throws InterruptedException {
		Thread.sleep(2000);
		firstAddress.click();
	}
	
	public void proceedToPayment() throws InterruptedException {
		Thread.sleep(2000);
		proceedToPaymentBtn.click();
	}
}

