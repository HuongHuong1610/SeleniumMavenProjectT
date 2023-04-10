package pages;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CustomerRolesUtil;

import java.util.List;

public class CustomerRolesPage extends BaseTest {
    Common common = new Common();
    CustomerRolesUtil customerRolesElement = new CustomerRolesUtil();

    public void click_edit(String name) {
        common.click(By.xpath("//td[contains(text(), '" + name + "')]//following-sibling::*//a[@class = 'btn btn-default']"));
    }

    public void clickBtnChooseProduct() {
        common.click(customerRolesElement.btn_ChooseProduct);
    }

    public void switchToWindow(String tittle) {
        common.switchToWindow(tittle);
    }

    public void selectProduct(int index) {
        List<WebElement> listPro = common.findElements(customerRolesElement.btn_select);
        listPro.get(index).click();
    }

    public void click_save(){
        common.click(customerRolesElement.btn_save);
        common.waitForMessageDisplayed();
    }
}
