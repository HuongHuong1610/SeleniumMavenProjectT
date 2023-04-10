package util;

import org.openqa.selenium.By;

public class CustomerRolesUtil extends AbstractPageUtil {
    public By btn_ChooseProduct = By.xpath("//button[contains(text(), 'Choose a product')]");
    public By btn_select = By.xpath("//button[contains(text(), 'Select')]");
}
