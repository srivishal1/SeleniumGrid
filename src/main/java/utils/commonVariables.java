package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.Markup;

import utils.*;

public class commonVariables {

	public static ExtentReports extent;

	private static ThreadLocal<commonFunctions> commonFunctionLib = new ThreadLocal<commonFunctions>();

	public static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

	private static ThreadLocal<driverFunctions> driverFunctionLib = new ThreadLocal<driverFunctions>();

	public static ThreadLocal<ExtentTest> currentTestClassLog = new ThreadLocal();

	public static ThreadLocal<ExtentTest> currentTestCaseLog = new ThreadLocal();

	public static WebDriver getDriver() {
		return webDriver.get();
	}

	public static void setDriver(WebDriver driver) {
		webDriver.set(driver);
	}

	public static driverFunctions getDriverFunctionLib() {
		return driverFunctionLib.get();
	}

	public static void setDriverFunctionLib(driverFunctions driverFunctionlib) {
		driverFunctionLib.set(driverFunctionlib);
	}

	public static commonFunctions getCommonFunctionLib() {
		return commonFunctionLib.get();
	}

	public static void setCommonFunctionLib(commonFunctions commonFunctionlib) {
		commonFunctionLib.set(commonFunctionlib);
	}

}
