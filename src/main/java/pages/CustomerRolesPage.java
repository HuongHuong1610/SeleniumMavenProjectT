package pages;

import core.WebElementHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.CustomerRolesUtil;

import java.util.List;

public class CustomerRolesPage extends AbstractPage {
    WebElementHelper common = new WebElementHelper();
    CustomerRolesUtil customerRolesElement = new CustomerRolesUtil();

    public void clickEdit(String name) {
        webElementHelper.click(By.xpath("//td[contains(text(), '" + name + "')]//following-sibling::*//a[@class = 'btn btn-default']"));
    }

    public void clickBtnChooseProduct() {
        webElementHelper.click(customerRolesElement.btn_ChooseProduct);
    }

    public void switchToWindow(String tittle) {
        webElementHelper.switchToWindow(tittle);
    }

    public void selectProduct(int index) {
        List<WebElement> listPro = webElementHelper.findElements(customerRolesElement.btn_select);
        listPro.get(index).click();
    }

}
