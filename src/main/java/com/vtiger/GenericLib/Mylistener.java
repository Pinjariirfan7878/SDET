package com.vtiger.GenericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;
import com.mysql.cj.xdevapi.Result;

public class Mylistener extends BaseUtilityClass implements ITestListener {

	ExtentSparkReporter reporter;
	ExtentReports reports;
	ExtentTest test;
	FileLib flib =new FileLib();


	@Override
	public void onTestStart(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is start");
		test=reports.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is Passed");
		test.log(Status.PASS, result.getMethod().getMethodName()+" got Pass");
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		System.out.println(result.getMethod().getMethodName()+" is Fail");
		test.log(Status.FAIL, result.getMethod().getMethodName()+" got Fail");

		TakesScreenshot ts=(TakesScreenshot)sdriver;
		File scr=ts.getScreenshotAs(OutputType.FILE);
		String path=IAutoconsts.Screenshot_PATH+result.getMethod().getMethodName()+".png";
		File dsn=new File(path);
		try {
			Files.copy(scr, dsn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		System.out.println(" TC Skipped");
		test.log(Status.SKIP, result.getMethod().getMethodName()+" got Skip");
	}

	@Override
	public void onStart(ITestContext context) 
	{
		reporter=new ExtentSparkReporter(IAutoconsts.Extendreport_PATH);
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setDocumentTitle("Vtiger");

		reports=new ExtentReports();
		reports.attachReporter(reporter);
		reports.setSystemInfo("created by ", "Irfan");
		reports.setSystemInfo("Tester", "MR.Irfan");
		reports.setSystemInfo("Environment", "QA");
		try {
			reports.setSystemInfo("browser",flib.readPropertyData(PROP_PATH, "browser"));
		} catch (Throwable e) {

			e.printStackTrace();
		}
		reports.setSystemInfo("version", "103.10");
	}

	@Override
	public void onFinish(ITestContext context)
	{
		System.out.println("Finished Execution");
		reports.flush();
	}

}
