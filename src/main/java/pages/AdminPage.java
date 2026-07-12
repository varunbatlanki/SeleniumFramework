package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class AdminPage extends BasePage {

	private final By adminHeader = By.xpath("//h6[text()='Admin']");

	public boolean isAdminPageDisplayed() {

		return isDisplayed(adminHeader);

	}

}