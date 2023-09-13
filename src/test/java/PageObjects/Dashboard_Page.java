package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.Base_Page;

public class Dashboard_Page extends Base_Page{

	

	public Dashboard_Page(WebDriver driver, WebDriverWait mywait, JavascriptExecutor js) 
	{
		super(driver, mywait, js);
		
	}

	@FindBy(xpath = "//span[text()='My Account']")
	WebElement myAccount_loc;
	
	@FindBy(xpath = "//a[contains(.,'Register')]")
	WebElement register_loc;
	
	@FindBy(xpath = "//a[contains(.,'Login')]")
	WebElement login_loc;
	
	
	public void OpenRegisterPage()
	{
		myAccount_loc.click();
		register_loc.click();
	}
	
	public void OpenLoginPage()
	{
		myAccount_loc.click();
		login_loc.click();
	}
	
		
}
	
	
	

