package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})   //Step no. 7
	public void verify_login()
	{
		logger.info("**** Starting TC_002_Login Test ****");
		try
		{
		//HomePage
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on My Account link..");
		hp.clickMyAccount();
		hp.clickLogin();
		
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing user account details..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		logger.info("Validating My Account Heading is displayed or not..");
		boolean targetpage=macc.isMyAccountPageExists();
		
		Assert.assertTrue(targetpage);   // If this is true, login was successful!
		//Assert.assertTrue(targetPage, "Login failed:-'My Account' heading is not displayed.");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("**** Finished TC_002_Login Test ****");
	}
	
}
