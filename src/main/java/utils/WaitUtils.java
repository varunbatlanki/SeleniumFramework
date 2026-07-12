package utils;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverFactory;

public class WaitUtils {

	private WaitUtils() {
	}

	private static final Logger logger = LogManager.getLogger(WaitUtils.class);

	public static WebElement waitForVisibility(By locator) {

		logger.info("Waiting for element visibility : {}", locator);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
				Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("explicitWait"))));

		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static WebElement waitForClickable(By locator) {

		logger.info("Waiting for element Clickablility : {}", locator);
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),
				Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("explicitWait"))));

		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

}