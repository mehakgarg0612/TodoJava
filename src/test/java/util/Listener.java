package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
	
	// This class is used to generate Extent Reports for the test cases
	// You can customize the report generation logic here
	// For example, you can set the report title, theme, etc.
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Starting test: " + context.getName());
	}
	
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Finished test: " + context.getName());
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Starting test case: " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case passed: " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed: " + result.getName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped: " + result.getName());
	}

}
