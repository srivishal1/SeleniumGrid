package pagefunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v101.input.Input;

import ObjectRepositories.contactPage_OR;

public class contactPage extends contactPage_OR {
	
	public contactPage (WebDriver driver) throws Exception {
		super(driver);
		this.driver = driver;
		if(!driverFunctionLib.isElementPresent(firstName)) {
			throw new IllegalStateException("This is not contact us Page");
		}
	}
}
