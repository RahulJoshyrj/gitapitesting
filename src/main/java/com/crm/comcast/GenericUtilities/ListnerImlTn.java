package com.crm.comcast.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImlTn implements ITestListener {

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		String testname=result.getMethod().getMethodName();
		System.out.println("<------------Iam Listnening------>");
		TakesScreenshot screenshot=(TakesScreenshot)BaseClass.sdriver;
		File src=screenshot.getScreenshotAs(OutputType.FILE);
		String datetime=LocalDateTime.now().toString().replace(" ", " ").replace(" ", " ");
		File dst=new File("screenshots/"+"_"+testname+"_"+datetime+".PNG");
		try {
			FileUtils.copyFile(src, dst);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("problem in saving screeshot "+e.getMessage());
		}
		
	}

	public void onTestFailure(ITestResult result) {
		
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	public void onFinish(ITestContext context) {
	}

}
