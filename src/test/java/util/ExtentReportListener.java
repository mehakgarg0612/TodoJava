package util;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // initialize the HtmlReporter
  
    	    ExtentSparkReporter sparkReporter = new ExtentSparkReporter("reports/RegistrationTestReport.html");
    	    extent = new ExtentReports();
    	    extent.attachReporter(sparkReporter);
    	    extent.setSystemInfo("Suite Name", context.getSuite().getName());
    	}

    @Override
    public void onTestStart(ITestResult result) {
        // create a test node in the report
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testThread.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testThread.get().pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        testThread.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testThread.get().skip("Test skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // writes everything to the HTML
    }
    
    public static ExtentTest getTest() {
        return testThread.get();
    }


    // You can leave other ITestListener methods empty if you don’t need them
}
