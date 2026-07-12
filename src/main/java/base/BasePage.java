package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.DriverFactory;
import utils.WaitUtils;

public class BasePage {

	protected WebElement getElement(By locator) {
		return DriverFactory.getDriver().findElement(locator);
	}

	protected void click(By locator) {
		WaitUtils.waitForClickable(locator).click();
	}

	protected void type(By locator, String value) {
		WebElement element = WaitUtils.waitForVisibility(locator);
		element.clear();
		element.sendKeys(value);
	}

	protected String getText(By locator) {
		return WaitUtils.waitForVisibility(locator).getText();
	}

	protected boolean isDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	protected String getPageTitle() {
		return DriverFactory.getDriver().getTitle();
	}

	protected String getCurrentUrl() {
		return DriverFactory.getDriver().getCurrentUrl();
	}

}