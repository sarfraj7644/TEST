package com.crm.campaign;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extend_Report1 implements ITestListener{
	public ExtentReports report;
	public ExtentTest test;
	public WebDriver driver;
	public void onTestStart(ITestResult result) {
		test=report.createTest("extent Demo");
		
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "test is pass");
		
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "test is fail");
		TakesScreenshot t=(TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ExtentReport/report.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "test is skipped");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		test=report.createTest("extent Demo");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}

}
