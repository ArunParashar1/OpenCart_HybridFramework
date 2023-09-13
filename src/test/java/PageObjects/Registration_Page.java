package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


import BasePage.Base_Page;

public class Registration_Page extends Base_Page{

	

	public Registration_Page(WebDriver driver, WebDriverWait mywait, JavascriptExecutor js) 
	{
		super(driver, mywait, js);
		
	}

	@FindBy(id = "input-firstname")
	WebElement text_register_firstName_loc;
	
	@FindBy(id = "input-lastname")
	WebElement text_register_lastName_loc;
	
	@FindBy(id = "input-email")
	WebElement text_register_email_loc;
	
	@FindBy(id = "input-password")
	WebElement text_register_password_loc;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkBox_register_PrivacyPolicy_loc;
	
	@FindBy(css = "button[type='submit']")
	WebElement button_register_SubmitForm_loc;
	
	public void setFirstName(String Firstname)
	{
		text_register_firstName_loc.sendKeys(Firstname);
	}
	
	public void setLastName(String Lastname)
	{
		text_register_lastName_loc.sendKeys(Lastname);
	}
	
	public void setEmail(String email)
	{
		text_register_email_loc.sendKeys(email);
	}
	
	public void setPassword(String Password)
	{
		text_register_password_loc.sendKeys(Password);
	}
	
	public void agreePolicyandProceed()
	{
		js.executeScript("arguments[0].click();", checkBox_register_PrivacyPolicy_loc);
		//button_register_SubmitForm_loc.click();
	}
}
