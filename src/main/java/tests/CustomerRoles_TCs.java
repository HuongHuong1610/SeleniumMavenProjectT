package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.CustomerRoles_element;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CustomerRoles_TCs extends BaseTest {
    Common common = new Common();
    CustomerRoles_element customerRolesElement = new CustomerRoles_element();

    public void click_edit(String name) {
        common.click(By.xpath("//td[contains(text(), '" + name + "')]//following-sibling::*//a[@class = 'btn btn-default']"));
    }

    public void click_btn_chooseProduct() {
        common.click(customerRolesElement.btn_ChooseProduct);
    }

    public void displayedPopUp() {
        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
        String subWindowHandler = null;

        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        selectProduct(0);
        driver.switchTo().window(parentWindowHandler);
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
