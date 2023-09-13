package BaseTest;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

//import io.github.bonigarcia.wdm.WebDriverManager;


public class Base_common_Methods {
	
	public static WebDriver driver;
	public WebDriverWait mywait;
	public JavascriptExecutor js;
	public Logger logger;
	public ResourceBundle res_bundle;
	
	@BeforeClass
	@Parameters("browser")
	public void OpenApp(String br)
	{
		//WebDriverManager.chromedriver().setup();
		if (br.equals("chrome")) {
			
			driver = new ChromeDriver();
		}
		else if (br.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		
		else {
			
			driver = new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger = LogManager.getLogger(this.getClass());
		mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		js= (JavascriptExecutor) driver;
		res_bundle = ResourceBundle.getBundle("config"); //Calling Properties File
		driver.get(res_bundle.getString("Url")); 
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		return RandomStringUtils.randomAlphabetic(5);
		
	}
	
	public String randomNumeric()
	{
		return RandomStringUtils.randomNumeric(5);
	}
	
	public String captureScreenshot(String test_name)
	{
		String timestamp = new SimpleDateFormat("yyyy.MMM.dd.HH.mm.ss").format(new Date());
		
		TakesScreenshot take_screenshot = (TakesScreenshot) driver;
		File source_file =  take_screenshot.getScreenshotAs(OutputType.FILE);
		String file_destination_path = System.getProperty("user.dir") + "\\screenshots\\" +test_name+ "_" +timestamp+ ".png";
		File target_file = new File(file_destination_path);
		
		try {
			
			FileUtils.copyFile(source_file, target_file);
			
		} catch (Exception e) {
			e.getMessage();
		}
		
		return file_destination_path;
		
	}
}
