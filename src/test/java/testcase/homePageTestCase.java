package testcase;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pagefunctions.homePage;
import utils.commonVariables;

public class homePageTestCase extends baseTestCase {

	@Test
	public void verifyHomePage() throws Exception {
		Boolean testcaseStatus = true;
		String errorMsg="";
		try {
		contactPage = homePage.clickContactLink();
		}
		catch (Exception e) {
			testcaseStatus = false;
			System.out.println(e.getMessage());
			errorMsg = e.getMessage();
		}
		if(!testcaseStatus) {
			commonVariables.currentTestCaseLog.get().fail(errorMsg);
		}
		assertTrue(testcaseStatus);
	}
}
