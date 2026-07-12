package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

public class BrowserFactory {

	private BrowserFactory() {
		// Prevent object creation
	}

	String browser = ConfigReader.getProperty("browser").toLowerCase();

	public static WebDriver createDriver(String browser) {

		switch (browser) {

		case "chrome":
			return createChromeDriver();

		case "firefox":
			return createFirefoxDriver();

		case "edge":
			return createEdgeDriver();

		default:
			throw new IllegalArgumentException("Unsupported browser: " + browser);
		}
	}

	private static WebDriver createChromeDriver() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		configureCommonOptions(options);

		return new ChromeDriver(options);
	}

	private static WebDriver createFirefoxDriver() {

		WebDriverManager.firefoxdriver().setup();

		FirefoxOptions options = new FirefoxOptions();

		configureCommonOptions(options);

		return new FirefoxDriver(options);
	}

	private static WebDriver createEdgeDriver() {

		WebDriverManager.edgedriver().setup();

		EdgeOptions options = new EdgeOptions();

		configureCommonOptions(options);

		return new EdgeDriver(options);
	}

	/**
	 * Common browser configurations applicable to all browsers
	 */
	private static void configureCommonOptions(ChromeOptions options) {

		if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			options.addArguments("--headless=new");
		}

		if (Boolean.parseBoolean(ConfigReader.getProperty("incognito"))) {
			options.addArguments("--incognito");
		}

		if (Boolean.parseBoolean(ConfigReader.getProperty("maximize"))) {
			options.addArguments("--start-maximized");
		}

		options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigReader.getProperty("acceptInsecureCertificates")));
	}

	private static void configureCommonOptions(FirefoxOptions options) {

		if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			options.addArguments("-headless");
		}

		options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigReader.getProperty("acceptInsecureCertificates")));
	}

	private static void configureCommonOptions(EdgeOptions options) {

		if (Boolean.parseBoolean(ConfigReader.getProperty("headless"))) {
			options.addArguments("--headless=new");
		}

		if (Boolean.parseBoolean(ConfigReader.getProperty("incognito"))) {
			options.addArguments("--inprivate");
		}

		if (Boolean.parseBoolean(ConfigReader.getProperty("maximize"))) {
			options.addArguments("--start-maximized");
		}

		options.setAcceptInsecureCerts(Boolean.parseBoolean(ConfigReader.getProperty("acceptInsecureCertificates")));
	}
}
