package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentOptionsPage {
WebDriver driver;

@FindBy(xpath = "(//mat-radio-button)[1]")
private WebElement firstPaymentCard;

@FindBy(xpath = "//button[@aria-label='Proceed to review']")
private WebElement proceedToReview;


	public PaymentOptionsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectPaymentCard() throws InterruptedException {
		Thread.sleep(2000);
		firstPaymentCard.click();
	}
	
	public void proceedToReviewOrder() {
		proceedToReview.click();
	}
		
	
}

