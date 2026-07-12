package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import utils.ConfigReader;

public class RetryAnalyzer implements IRetryAnalyzer {

	private int retryCount = 0;

	private final int maxRetryCount = Integer.parseInt(ConfigReader.getProperty("retryCount"));

	@Override
	public boolean retry(ITestResult result) {

		if (shouldRetry(result) && retryCount < maxRetryCount) {

			retryCount++;

			return true;
		}

		return false;
	}

	/**
	 * Retry only transient failures.
	 */
	private boolean shouldRetry(ITestResult result) {

		Throwable throwable = result.getThrowable();

		if (throwable == null) {
			return false;
		}

		String exception = throwable.getClass().getSimpleName();

		return exception.equals("TimeoutException") || exception.equals("StaleElementReferenceException")
				|| exception.equals("ElementClickInterceptedException");
	}

}