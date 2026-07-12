package components;

import org.openqa.selenium.By;

import base.BasePage;

public class TableComponent extends BasePage {

	/**
	 * Click Action Button for a Row
	 */

	public void clickActionButton(String rowText) {

		click(

				By.xpath("//div[@role='row']"+ "[.//div[text()='"+ rowText+ "']]"+ "//button"));

	}

	/**
	 * Returns whether row exists
	 */

	public boolean isRowPresent(String rowText) {

		return isDisplayed(

				By.xpath("//div[@role='row']"

								+ "[.//div[text()='"

								+ rowText

								+ "']]"));

	}

}