package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseTest.Base_common_Methods;
import PageObjects.Dashboard_Page;
import PageObjects.Login_Page;
import PageObjects.MyAccount_Page;
import utilities.Data_Provider;

public class Login_OpenCart_Test extends Base_common_Methods{
	
	
	@Test(dataProvider = "loginData" , dataProviderClass = Data_Provider.class)
	public void loginApplication(String email, String pwd, String exp_result)
	{
		try {
		logger.info("*********** Test login Application Feature**************");
		
		Dashboard_Page dp = new Dashboard_Page(driver, mywait, js);
		dp.OpenLoginPage();
		
		Login_Page lp = new Login_Page(driver, mywait, js);
		lp.provideemail(email);
		lp.providePassword(pwd);
		lp.clickLoginButton();
		
		MyAccount_Page myaccpage = new MyAccount_Page(driver, mywait, js);
		boolean target_accountpage = myaccpage.isMyAccountPageExists();
		
		if(exp_result.equals("valid"))
		{
			if(target_accountpage==true)
			{
				myaccpage.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		
		if(exp_result.equals("Invalid"))
		{
			if (target_accountpage==true) {
				
				myaccpage.clickLogout();
				Assert.assertTrue(false);
				
				
			} else {
				Assert.assertTrue(true);

			}
		}
		
	}catch(Exception e)
		{
			e.getMessage();
			Assert.fail();
		}
	
	}

}
