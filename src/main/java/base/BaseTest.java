package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.BrowserFactory;
import driver.DriverFactory;
import utils.ConfigReader;

public class BaseTest {

	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeMethod

	public void setup() {

		logger.info("========== Test Started ==========");

		WebDriver driver = BrowserFactory.createDriver(ConfigReader.getBrowser());

		DriverFactory.setDriver(driver);

		logger.info("Browser Launched : {}", ConfigReader.getBrowser());

		DriverFactory.getDriver().get(ConfigReader.getProperty("url"));

		logger.info("Navigated to {}", ConfigReader.getProperty("url"));
	}

	@AfterMethod(alwaysRun = true)

	public void tearDown() {

		logger.info("Closing Browser");

		if (DriverFactory.getDriver() != null) {

			DriverFactory.getDriver().quit();

			DriverFactory.unload();

		}

		logger.info("========== Test Finished ==========");

	}

}