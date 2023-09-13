package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.Base_common_Methods;
import PageObjects.Dashboard_Page;
import PageObjects.Registration_Page;

public class Register_Account_Test extends Base_common_Methods{
	
	@Test
	public void RegisterAccount()
	{
		logger.info("*********** Test Registation Starting**************");
		try 
		{
		Dashboard_Page dp = new Dashboard_Page(driver, mywait, js);
		logger.info("*********** Open Register Page**************");
		dp.OpenRegisterPage();
		
		Registration_Page rp = new Registration_Page(driver, mywait, js);
		rp.setFirstName(randomString().toUpperCase());
		logger.info("*********** Enter First Name **************");
		rp.setLastName(randomString().toUpperCase());
		logger.info("*********** Enter Last Name **************");
		rp.setEmail(randomNumeric()+"@gmail.com");
		logger.info("*********** Enter Email **************");
		rp.setPassword(randomNumeric());
		logger.info("*********** Enter Password **************");
		rp.agreePolicyandProceed();
		logger.info("*********** Accept Policy **************");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			e.getMessage();
			Assert.fail();
		}
	}
	
	

}
