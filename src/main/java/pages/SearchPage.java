package pages;

import org.openqa.selenium.By;

import base.BasePage;

public class SearchPage extends BasePage {

	private final By employeeName = By.xpath("//input[@placeholder='Type for hints...']");

	private final By searchButton = By.xpath("//button[@type='submit']");

	public void searchEmployee(String employee) {

		type(employeeName, employee);

		click(searchButton);

	}

}