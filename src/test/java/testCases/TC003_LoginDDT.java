package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class,groups="DataDriven") //getting dataprovider from different class
	public void verify_LoginDDT(String email, String pwd, String exp)  //Step no. 6
	{
		
		logger.info("**** Starting TC_003_LoginDDT ****");
	  try
	  {
		//HomePage
		HomePage hp=new HomePage(driver);
		logger.info("Clicked on My Account link..");
		hp.clickMyAccount();
		hp.clickLogin();
				
		//LoginPage
		LoginPage lp=new LoginPage(driver);
		logger.info("Providing DDT user account details..");
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
				
		//MyAccountPage
		MyAccountPage macc=new MyAccountPage(driver);
		//logger.info("Validating My Account Heading is displayed or not..");
		boolean targetpage=macc.isMyAccountPageExists();
				
		/* 
		 Data is valid --> login success --> Test pass --> Logout
		  				   login failed -->  Test fail
		 
		 Data is invalid --> login success --> Test fail --> Logout
		  					 login failed -->  Test pass 
		*/
		
		if(exp.equalsIgnoreCase("Valid"))  //If data is Valid
		{
			if(targetpage==true)   //login success, then test pass and logout 
			{
				macc.clickLogout();  //put it before assertion because no action will execute after assertion
				Assert.assertTrue(true); //Assertion should always be after action
			}
			else      //and if login failed then test fail so you don't need to logout because u haven't logged-in
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))  //If data is Invalid
		{
			if(targetpage==true)    //login is success, then test failed because of invalid data
			{
				macc.clickLogout();  //but need to logout
				Assert.assertTrue(false);
			}
			else    //and if login failed then test passed, so you don't need to logout because u haven't logged in
			{
				Assert.assertTrue(true);
			}
		}
	  }catch(Exception e)
	  {
		 Assert.fail();
	  }
		
		logger.info("**** Finished TC_003_LoginDDT ****");
		
	}
	
}
