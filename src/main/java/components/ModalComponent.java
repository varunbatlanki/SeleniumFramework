package components;

import org.openqa.selenium.By;

import base.BasePage;

public class ModalComponent extends BasePage {

	private final By yesButton = By.xpath("//button[normalize-space()='Yes']");

	private final By noButton = By.xpath("//button[normalize-space()='No']");

	private final By cancelButton = By.xpath("//button[normalize-space()='Cancel']");

	public void confirm() {

		click(yesButton);

	}

	public void cancel() {

		click(cancelButton);

	}

	public void decline() {

		click(noButton);

	}

}