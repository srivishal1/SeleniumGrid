package utils;

import java.net.URL;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.*;


public class startDriver {
	DesiredCapabilities objCapabilities;
	ChromeOptions chromeoptions;
	public Set<String> arrKnownBrowserHwnd;       //Stores windows handle when launching a new browser
	public String hwndFirstWindow;
	WebDriver driver;
	commonFunctions commonFunc = commonVariables.getCommonFunctionLib();
	driverFunctions driverFunc;
	
	public synchronized WebDriver startDriver(String browserType) throws Exception {
//		String gridIp = configManager.getProperties().getProperty("SeleniumGridHubIP");
//		String gridPort = configManager.getProperties().getProperty("port");
//		if(System.getProperty("SeleniumGridHubIP")!=null) {
//			gridIp = System.getProperty("SeleniumGridHubIP");
//			gridPort = System.getProperty("port");
//		}
//		objCapabilities = new DesiredCapabilities();
//		objCapabilities.setBrowserName("chrome");
//		driver = new RemoteWebDriver(new URL("http://"+gridIp+":"+gridPort),objCapabilities);

		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		options.addArguments("--disable-gpu");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("window-size=1200x600");
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);

		commonVariables.setDriver(driver);
		commonVariables.setDriverFunctionLib(new driverFunctions());
		commonVariables.setCommonFunctionLib(new commonFunctions()) ;
		commonVariables.getDriverFunctionLib().openUrl(configManager.getProperties().getProperty("url"));
		return driver;
	}
}
