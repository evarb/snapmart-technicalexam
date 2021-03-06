package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}
	
	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}
	
	private WebDriver createDriver() {
	    switch (environmentType) {     
	         case LOCAL : driver = createLocalDriver();
	         	break;
	         case REMOTE : driver = createRemoteDriver();
	         	break;
	    }
	    return driver;
	 }
	
	 private WebDriver createRemoteDriver() {
		 throw new RuntimeException("RemoteWebDriver is not yet implemented");
	 }
	
	 private WebDriver createLocalDriver() {
		 switch (driverType) {     
		 case FIREFOX : driver = new FirefoxDriver();
	     break;
	     case CHROME : 
	    	 System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
	    	 ChromeOptions options = new ChromeOptions();
	    	 options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
	    	 driver = new ChromeDriver(options);
	    	 
	     break;
	      }
	        if(FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize()) driver.manage().window().maximize();
	        	driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(), TimeUnit.SECONDS);
	     return driver;
	 }
	 
	 public void closeDriver() {
		 driver.close();
		 driver.quit();
	 }
	
	
}
