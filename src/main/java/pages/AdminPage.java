package pages;

import org.openqa.selenium.By;

import base.BasePage;
import utils.WaitUtils;

public class AdminPage extends BasePage {

	private final By adminHeader = By.xpath("//h6[text()='Admin']");

	public boolean isAdminPageDisplayed() {

		WaitUtils.waitForVisibility(adminHeader);
		return isDisplayed(adminHeader);

	}

}