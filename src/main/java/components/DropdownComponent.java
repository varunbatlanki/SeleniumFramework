package components;

import org.openqa.selenium.By;

import base.BasePage;

public class DropdownComponent extends BasePage {

    /**
     * Generic dropdown selection
     */

    public void select(By dropdown,

                       String value) {

        click(dropdown);

        click(

                By.xpath(

                        "//span[text()='"

                                + value

                                + "']"));

    }

}