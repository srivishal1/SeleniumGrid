package testcase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pagefunctions.contactPage;
import pagefunctions.homePage;
import utils.commonVariables;
import utils.configManager;
import utils.extentManager;
import utils.startDriver;

public class baseTestCase {
	
	protected homePage homePage;
	protected contactPage contactPage;
	ExtentTest testcase;
	public static String reportPath = "";
	static String timestamp = "";

	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext context) throws IOException {
		configManager.setProperties();
		String basePath = System.getProperty("user.dir");
		String Report_Root_Path = basePath + "/logs/Results/" + timestamp;
		reportPath = Report_Root_Path;
		Path p = Paths.get(reportPath);
	     Files.createDirectories(p);
	    commonVariables.extent = extentManager.createInstance(Report_Root_Path + "//GlobalReport.html");
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(Report_Root_Path + "//GlobalReport.html");
		commonVariables.extent.attachReporter(htmlReporter);
		commonVariables.extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
		commonVariables.extent.setAnalysisStrategy(AnalysisStrategy.TEST);
	}
	
	@BeforeClass(alwaysRun = true)
	public void beforeClass() throws Exception {
		ExtentTest classTest = commonVariables.extent.createTest(getClass().getName());
		commonVariables.currentTestClassLog.set(classTest);
		commonVariables
		.setDriver(new startDriver().startDriver(configManager.getProperties().getProperty("browser")));
		homePage = new homePage(commonVariables.getDriver());
	}
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(Method method) {
		testcase = commonVariables.currentTestClassLog.get().createNode(method.getName());
		commonVariables.currentTestCaseLog.set(testcase);
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(Method method, ITestResult result, ITestContext context) {
		commonVariables.extent.flush();
	}
	
	@AfterClass(alwaysRun = true)
	public void afterTest() throws Exception {
		commonVariables.getDriver().quit();
	}
}
