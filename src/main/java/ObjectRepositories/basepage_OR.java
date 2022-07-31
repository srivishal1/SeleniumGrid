package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import utils.commonFunctions;
import utils.commonVariables;
import utils.driverFunctions;

public class basepage_OR {
	
	protected AjaxElementLocatorFactory ajaxElemFactory;
	protected Integer ajaxElementTimeout = 30;
    public WebDriver driver;
    protected commonFunctions commonFunctionLib;
    protected driverFunctions driverFunctionLib;
	
	public basepage_OR(WebDriver driver) {
		super();
		commonFunctionLib = commonVariables.getCommonFunctionLib();
        driverFunctionLib = commonVariables.getDriverFunctionLib();
		this.driver = driver;
	}
	
}
