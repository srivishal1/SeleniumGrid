package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import utils.commonFunctions;
import utils.commonVariables;
import utils.driverFunctions;


public class contactPage_OR extends basepage_OR {
	
    
	public contactPage_OR(WebDriver driver) {
		 super(driver);
		 ajaxElemFactory = new AjaxElementLocatorFactory(driver, ajaxElementTimeout);
         PageFactory.initElements(ajaxElemFactory, this);
         this.driver = driver;
	}

	 	@FindBy(id = "FirstName")
	    protected WebElement firstName;
	    
	    @FindBy(xpath = "//a[@class='menu icon-menu is-mobile']")
	    public WebElement menuIcon;

	    @FindBy(xpath = "//a[@class='icon-close']")
	    public WebElement closeMenuIcon;

}
