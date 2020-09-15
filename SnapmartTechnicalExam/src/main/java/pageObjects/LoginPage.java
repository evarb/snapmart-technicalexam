package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import dataProvider.ConfigFileReader;
import managers.FileReaderManager;

public class LoginPage {
	WebDriver driver;
	ConfigFileReader configFileReader;

	
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
		driver.get(FileReaderManager.getInstance().getConfigFileReader().getApplicationUrl());
		dismissBtn.click();
	}
	
	public void login() {
		userEmail.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getUserEmail());
		userPassword.sendKeys(FileReaderManager.getInstance().getConfigFileReader().getUserPassword());
		loginBtn.click();
	}

}
