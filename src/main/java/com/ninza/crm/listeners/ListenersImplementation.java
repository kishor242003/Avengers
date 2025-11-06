package com.ninza.crm.listeners;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ninza.crm.generic.baseutility.BaseClass;

/**
 * @author Kishor Kulkarni
 * class contains the methods of Listeners Implementation
 */
public class ListenersImplementation implements ITestListener,ISuiteListener {
	ExtentReports report;
	ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		Date d=new Date();
		String date = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./Advance Report/"+date+" crmreport.html");
		spark.config().setDocumentTitle("Ninza");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
	    report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("browser", "chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test = report.createTest(testCase);
		test.log(Status.INFO,testCase+ " Execution Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.PASS,testCase+ " Execution Success");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.FAIL,testCase+ " Execution Fail");
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String src = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(src);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testCase = result.getMethod().getMethodName();
		test.log(Status.SKIP,testCase+ " Execution Skipped");		
	}
	
	
	
	

}
