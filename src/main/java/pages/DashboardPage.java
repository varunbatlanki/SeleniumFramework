package pages;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.apache.logging.log4j.Logger;

import base.BasePage;
import components.HeaderComponent;
import components.LeftMenuComponent;
import utils.WaitUtils;

public class DashboardPage extends BasePage {

	// Dashboard Locators
	private final By dashboardTitle = By.xpath("//h6[text()='Dashboard']");

	// Components

	private final HeaderComponent header = new HeaderComponent();

	private final LeftMenuComponent menu = new LeftMenuComponent();
	private static final Logger logger = LogManager.getLogger(DashboardPage.class);

	/**
	 * Dashboard Validation
	 */

	public boolean isDashboardDisplayed() {

		WaitUtils.waitForVisibility(dashboardTitle);

		logger.info("Verifying Dashboard");
		return isDisplayed(dashboardTitle);

	}

	/**
	 * Header Component
	 */

	public HeaderComponent header() {

		return header;

	}

	/**
	 * Left Menu Component
	 */

	public LeftMenuComponent menu() {

		return menu;

	}

	public AdminPage goToAdmin() {

	
		menu.openMenu("Admin");

		return new AdminPage();

	}

	public SearchPage goToPIM() {

		menu.openMenu("PIM");

		return new SearchPage();

	}

}