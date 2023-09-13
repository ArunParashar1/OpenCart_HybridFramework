package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.Base_Page;

public class Login_Page extends Base_Page{

	public Login_Page(WebDriver driver, WebDriverWait mywait, JavascriptExecutor js) {
		super(driver, mywait, js);
	
	}
	
	@FindBy(id = "input-email")
	WebElement txt_loginPage_email_loc;
	
	@FindBy(id = "input-password")
	WebElement txt_loginPage_password_loc;
	
	@FindBy(xpath = "//button[contains(.,'Login')]")
	WebElement button_loginPage_login_loc;
	
	public void provideemail(String email)
	{
		txt_loginPage_email_loc.sendKeys(email);
	}
	
	public void providePassword(String pwd)
	{
		txt_loginPage_password_loc.sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		button_loginPage_login_loc.click();
	}
}

