package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;

import base.BasePage;

public class LoginPage extends BasePage {

	// Locators
	private final By txtUsername = By.name("username");

	private final By txtPassword = By.name("password");

	private final By btnLogin = By.cssSelector("button[type='submit']");

	/**
	 * Business Method
	 */

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	public DashboardPage login(String username, String password) {

		logger.info("Entering Username");

		type(txtUsername, username);

		logger.info("Entering Password");

		type(txtPassword, password);

		logger.info("Clicking Login");

		click(btnLogin);

		logger.info("Login Completed");

		return new DashboardPage();

	}

}
