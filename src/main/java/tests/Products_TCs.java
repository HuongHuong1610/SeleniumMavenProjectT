package tests;

import core.WebBase;
import org.openqa.selenium.interactions.Actions;
import pages.Products_element;

public class Products_TCs extends WebBase {
    Products_element productsElement = new Products_element();
    Common common = new Common();

    public void verify_Productpage() {
        common.isDisplayed(productsElement.btn_add);
        common.isDisplayed(productsElement.btn_export);
        common.isDisplayed(productsElement.btn_import);
        common.isDisplayed(productsElement.btn_delete);
        common.isDisplayed(productsElement.product_name);
        common.isDisplayed(productsElement.warehouse);
        common.isDisplayed(productsElement.category);
        common.isDisplayed(productsElement.product_type);
    }

    public void click_add() {
        common.click(productsElement.btn_add);
    }

    public void input() {
        common.sendKeys(productsElement.name, "iphone");
        common.sendKeys(productsElement.description, "nothing");
        common.sendKeys(productsElement.sku, "1234567");
        common.click(productsElement.categories);
        common.click(productsElement.books);
        common.sendKeys(productsElement.price, "13");
        common.sendKeys(productsElement.old_price, "23");
    }

    public void click_save() {
        common.click(productsElement.btn_save);
        common.isDisplayed(productsElement.message);
    }

}
