package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(id = "email")
	private WebElement userEmail;
	
	@FindBy(id = "password")
	private WebElement userPassword;
	
	@FindBy(xpath = "//span[text()=' Log in ']")
	private WebElement loginBtn;
	
	@FindBy(xpath = "//span[text() = 'Dismiss']")
	private WebElement dismissBtn;
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public void goToLoginPage() {
		driver.get("http://210.16.121.50:3000/#/login");
		dismissBtn.click();
	}
	
	public void login() {
		userEmail.sendKeys("tinolangkabayo@gmail.com");
		userPassword.sendKeys("Jollibug123!1");
		loginBtn.click();
	}

}
