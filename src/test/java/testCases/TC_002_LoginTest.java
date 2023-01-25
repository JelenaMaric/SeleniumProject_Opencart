package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		logger.info("***Starting TC_002_LoginTest***");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Clicked on My account link");			
			hp.clickLogin();
			logger.info("Clicked on Login link");
			
			LoginPage lp=new LoginPage(driver);
			logger.info("Providing Login data");
			
			lp.setEmail(rb.getString("email")); 
			
			lp.setPassword(rb.getString("password"));
			
			lp.clickLogin();
			logger.info("Clicked on Login button");
			
			MyAccountPage macc=new MyAccountPage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
			
			logger.info("Validating expected message");
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Finished TC_002_LoginTest***");
		
	}	
}