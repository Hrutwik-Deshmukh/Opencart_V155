package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups={"Regression","Master"})  //Step no.7
	public void verify_account_registration()
	{
		logger.info("**** TC001_AccountRegistrationTest is Started ****");
		
		try
		{
		HomePage hp=new HomePage(driver);
		
		logger.info("Clicked on My Account link..");
		hp.clickMyAccount();
		
		logger.info("Clicked on Register link..");
		hp.clickRegister();
		
		logger.info("Providing Customer Details..");
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toLowerCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		String password=randomAlphaNumeric();
		
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating the expected message..");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		catch(Exception e)
		{
			logger.error("Test Failed..");
			//logger.debug("Debug logs..");
			Assert.fail();
		}
		
		logger.info("**** TC001_AccountRegistrationTest is Finished ****");
	}
	
}
