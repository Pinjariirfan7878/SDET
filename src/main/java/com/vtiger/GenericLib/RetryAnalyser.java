package com.vtiger.GenericLib;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer {


	int count=0;
	int trycount=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<trycount)
		{
			count++;
			return true;
		}
		return false;
	}
}



