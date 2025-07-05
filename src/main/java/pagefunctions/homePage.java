package pagefunctions;

import org.openqa.selenium.WebDriver;

import ObjectRepositories.*;
public class homePage extends homePage_OR {
   WebDriver driver;

	public homePage (WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		// if(!driverFunctionLib.isElementPresent(contactUs)) {
		// 	throw new IllegalStateException("This is not home Page");
		// }
	}

	public void getCurrentTime() {
		commonFunctionLib.saveScreenshot(null);
	}
	
	public contactPage clickContactLink() throws Exception {
		driverFunctionLib.click(contactUs);
		return new contactPage(driver);
	}

}
