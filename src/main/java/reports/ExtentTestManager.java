package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentTestManager {

	private ExtentTestManager() {
	}

	/**
	 * Thread-safe ExtentTest
	 */

	private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	/**
	 * Create Test
	 */

	public static void createTest(String testName) {

		ExtentTest test =

				ExtentManager

						.getInstance()

						.createTest(testName);

		extentTest.set(test);

	}

	/**
	 * Returns current thread ExtentTest
	 */

	public static ExtentTest getTest() {

		return extentTest.get();

	}

	/**
	 * Remove ThreadLocal
	 */

	public static void unload() {

		extentTest.remove();

	}

}