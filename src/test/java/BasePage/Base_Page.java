package BasePage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
	
	public WebDriver driver;
	public WebDriverWait mywait;
	public JavascriptExecutor js;
	
	public Base_Page(WebDriver driver, WebDriverWait mywait, JavascriptExecutor js) 
	{
		this.driver = driver;
		this.mywait = mywait;
		this.js = js;
		PageFactory.initElements(driver, this);
		
	}

}
