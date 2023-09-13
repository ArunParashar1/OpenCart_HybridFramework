package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.Base_Page;

public class MyAccount_Page extends Base_Page {

	

	public MyAccount_Page(WebDriver driver, WebDriverWait mywait, JavascriptExecutor js) {
		super(driver, mywait, js);
		
	}

	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement imagetext_myAccount_msgHeading_loc;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement button_myAccount_logout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (imagetext_myAccount_msgHeading_loc.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		button_myAccount_logout.click();

	}
	
}
