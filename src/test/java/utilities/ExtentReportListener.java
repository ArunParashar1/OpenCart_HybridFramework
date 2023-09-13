package utilities;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.Base_common_Methods;

public class ExtentReportListener implements ITestListener{
	
	public  ExtentSparkReporter sparkreporter;
	public  ExtentReports reports;
	public  ExtentTest test;
	public String Screenshot_image;
	
	String reportname;
	public void onStart(ITestContext testcontext)
	{
		String timestamp = new SimpleDateFormat("yyyy.MMM.dd.HH.mm.ss").format(new Date());
		reportname = "Test-Report" +timestamp+".html";
		
		//String path = System.getProperty("user.dir")+ "\\Reports\\ExtReport.html";
		sparkreporter = new ExtentSparkReporter(".\\reports\\"+reportname);
		sparkreporter.config().setDocumentTitle("OpenCart UI Automation");
		sparkreporter.config().setReportName("UI Automation Test Report");
		sparkreporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(sparkreporter);
		reports.setSystemInfo("OpenCart" , "Automation");
		reports.setSystemInfo("Envrioment" , "QA");
		reports.setSystemInfo("browser" , "");
		reports.setSystemInfo("Operating System" , System.getProperty("os.name"));
		reports.setSystemInfo("User Name", System.getProperty("user.name"));
		
	}
	
	/* public void onTestStart(ITestResult result) {
	        test = reports.createTest(result.getMethod().getMethodName());
	    }*/
	public void onTestSuccess(ITestResult result)
	{
		
		test = reports.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passes is " + result.getName());
		
	}
	public void onTestFailure(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed is " + result.getName());
		test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable().getMessage());
		
		try {
		Screenshot_image =  new Base_common_Methods().captureScreenshot(result.getName());
		test.addScreenCaptureFromPath(Screenshot_image);
		}
		
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped is " + result.getName());
		test.log(Status.SKIP, "Test Case Skipped is " + result.getThrowable().getMessage());
	}
	@AfterMethod(alwaysRun = true)
	public void onFinish(ITestContext testcontext)
	{
		reports.flush();
	}
	
	
	

}
