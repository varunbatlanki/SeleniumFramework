package components;

import org.openqa.selenium.By;

import base.BasePage;

public class HeaderComponent extends BasePage {

	// Locators
	private final By profileMenu = By.cssSelector(".oxd-userdropdown-name");

	private final By logout = By.xpath("//a[text()='Logout']");

	private final By about = By.xpath("//a[text()='About']");

	private final By support = By.xpath("//a[text()='Support']");

	private final By changePassword = By.xpath("//a[text()='Change Password']");

	/**
	 * Opens profile dropdown
	 */
	public void openProfileMenu() {
		click(profileMenu);
	}

	/**
	 * Logout
	 */
	public void logout() {

		openProfileMenu();

		click(logout);

	}

	/**
	 * Open About
	 */
	public void openAbout() {

		openProfileMenu();

		click(about);

	}

	/**
	 * Open Support
	 */
	public void openSupport() {

		openProfileMenu();

		click(support);

	}

	/**
	 * Change Password
	 */
	public void changePassword() {

		openProfileMenu();

		click(changePassword);

	}

}