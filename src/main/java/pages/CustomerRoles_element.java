package pages;

import org.openqa.selenium.By;

public class CustomerRoles_element extends Products_element {
    public By btn_ChooseProduct = By.xpath("//button[contains(text(), 'Choose a product')]");
    public By btn_select = By.xpath("//button[contains(text(), 'Select')]");
}
