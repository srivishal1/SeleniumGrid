package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class driverFunctions extends commonFunctions{
	
	private WebDriver driver;

	public driverFunctions() {
		// TODO Auto-generated constructor stub
	}

	public boolean openUrl(String url) {
		System.out.println("");
		try {
			commonVariables.getDriver().get(url);;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void click(WebElement webElement) throws Exception {
		commonVariables.currentTestCaseLog.get().info("Click on webelement");
		try {
			webElement.click();
		} catch (Exception e) {
			commonVariables.currentTestCaseLog.get().error("Error on clicking on webelement");
		}
	}
	
	public Boolean isElementPresent(WebElement webElement) throws Exception {

		try {
			return webElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean waitForElementVisible(final WebElement webElement, int waitTime) {
		WebDriverWait wait = new WebDriverWait(commonVariables.getDriver(), Duration.ofSeconds(waitTime));
		try {
			wait.until(ExpectedConditions.visibilityOf(webElement));
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
