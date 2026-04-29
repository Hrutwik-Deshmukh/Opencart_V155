package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	//Constructor
	public HomePage(WebDriver driver)   //Driver is passed from test class
	{
		super(driver);     //super(driver) calls BasePage constructor
	}                      //PageFactory initializes all @FindBy elements
	
	
	//Locators
	@FindBy(xpath="//a[@title='My Account']")
	WebElement lnkMyaccount;   //lnkMyaccount → "My Account" dropdown
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement lnkRegister;   //lnkRegister → "Register" option
	
	@FindBy(linkText="Login")
	WebElement lnklogin;    //lnklogin → "Login" option on Homepage in "My Account" dropdown

	
	//@FindBy annotation is used to define elements,which improves maintainability and readability.

	
	//Action Methods
	public void clickMyAccount()
	{
		lnkMyaccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnklogin.click();
	}


}
