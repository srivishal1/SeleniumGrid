package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


import utils.commonFunctions;
import utils.commonVariables;
import utils.driverFunctions;


public class homePage_OR extends basepage_OR {
	
	
  
	public homePage_OR(WebDriver driver) {
		 super(driver);
		 ajaxElemFactory = new AjaxElementLocatorFactory(driver, ajaxElementTimeout);
         PageFactory.initElements(ajaxElemFactory, this);
         this.driver = driver;
	}

	 	@FindBy(xpath = "//ul[@id='menu-search-menu']//following-sibling::a[text()='Contact']")
	    protected WebElement contactUs;
	    
	    @FindBy(xpath = "//a[@class='menu icon-menu is-mobile']")
	    public WebElement menuIcon;

	    @FindBy(xpath = "//a[@class='icon-close']")
	    public WebElement closeMenuIcon;

}
