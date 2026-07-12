package listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.ExtentManager;
import reports.ExtentTestManager;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListener.class);

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		logger.info("Starting Test : {}", testName);

		ExtentTestManager.createTest(testName);

		ExtentTestManager.getTest().info("Execution Started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		logger.info("Test Passed : {}", testName);

		ExtentTestManager.getTest().pass("Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();

		logger.error("Test Failed : {}", testName);

		Throwable throwable = result.getThrowable();

		ExtentTestManager.getTest().fail(throwable);

		String screenshotPath = ScreenshotUtils.capture(testName);

		try {

			ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);

		}

		catch (Exception e) {

			logger.error("Unable to attach screenshot", e);

		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {

		logger.warn("Test Skipped : {}", result.getMethod().getMethodName());

		ExtentTestManager.getTest().skip("Test Skipped");

	}

	@Override
	public void onFinish(ITestContext context) {

		logger.info("Execution Completed");

		ExtentManager.getInstance().flush();

		ExtentTestManager.unload();

	}

}