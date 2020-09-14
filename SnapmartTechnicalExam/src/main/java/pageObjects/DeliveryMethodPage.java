package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeliveryMethodPage {
WebDriver driver;

@FindBy(xpath = "//button[@aria-label='Proceed to delivery method selection']")
private WebElement proceedToDelivery;


	public DeliveryMethodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void chooseDeliverySpeed(String speed) throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-cell[contains(text(),'"+ speed +"')]")).click();
	}
	
	public void continueToPayment() throws InterruptedException {
		Thread.sleep(2000);
		proceedToDelivery.click();
	}
}

