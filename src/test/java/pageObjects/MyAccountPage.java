package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	
	//Constructor
	public MyAccountPage(WebDriver driver) 
	{
		super(driver);     //super(driver) calls BasePage constructor
	}
	
	//Locators
	@FindBy(xpath="//h2[normalize-space()='My Account']")   //My Account Page Heading
	WebElement msgHeading;             //Step no.5
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnkLogout;      //added in step no.6 in hybrid framework steps image
	
	public boolean isMyAccountPageExists()
	{
		try
		{
			return (msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public void clickLogout()
	{
		lnkLogout.click();
	}
	
	
	/*The try-catch block:- This is a "safety first" approach. 
	If the element msgHeading isn't found(perhaps the login failed and you never reached this page)
	then .isDisplayed() would throw an exception. 
	The catch block captures that exception and returns false instead of crashing your test.
	*/

}
