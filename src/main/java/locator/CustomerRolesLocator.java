package locator;

import org.openqa.selenium.By;

public class CustomerRolesLocator extends AbstractPageLocator {
    public By btn_ChooseProduct = By.xpath("//button[contains(text(), 'Choose a product')]");
    public By btn_select = By.xpath("//button[contains(text(), 'Select')]");
}
