package com.crm.Generic_utility;

import java.io.File;
import java.io.IOException;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationClass implements ITestListener{
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		/* Step:3 Create a test method during the test execution start*/
		test=report.createTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result)
	{
		/*Step:4 Log the pass method*/
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");

	}

	public void onTestFailure(ITestResult result) 
	{
		//Step 5
		/*Log fail method, take screenshot, attach screenshot to extent report, add exception log*/

		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		String filePath = null;

		try {
			filePath = new WebDriver_Utility().takeScreenshotOfPage(driver, result.getMethod().getMethodName());

			} catch (IOException e) {
			
			e.printStackTrace();
			}

			test.addScreenCaptureFromPath(filePath);


		
	}

	public void onTestSkipped(ITestResult result)
	{
		/*step:6 Log the skip method()*/

		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) 
	{
		System.out.println("Execution of Test Script started");

		/*Step:1 Extent report configuration*/

		Date d = new Date();
		System.out.println(d);
		String date = d.toString().replace(" ", "-").replace(":", "-");

		ExtentSparkReporter htmlReport=new ExtentSparkReporter(new File("extentreport.html"));
		htmlReport.config().setDocumentTitle("Extent Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("Functional Test");
		
		

/*Step:2 Attach the physical report and do the system configuration*/

		report = new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Environment", "Testing Environment");
		report.setSystemInfo("URL", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Shobha");
	
	}

	public void onFinish(ITestContext context)
	{
		report.flush();

	}
	
}
