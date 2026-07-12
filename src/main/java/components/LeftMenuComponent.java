package components;

import org.openqa.selenium.By;

import base.BasePage;

public class LeftMenuComponent extends BasePage {

	/**
	 * Opens any menu dynamically
	 */

	public void openMenu(String menuName) {

		click(

				By.xpath("//span[text()='"+ menuName +"']"));

	}

}