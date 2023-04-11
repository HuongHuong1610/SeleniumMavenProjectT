package pages;

import org.openqa.selenium.By;
import util.ProductsUtil;

public class ProductsPage extends AbstractPage {
    ProductsUtil productsElement = new ProductsUtil();
    Common common = new Common();

    public void verifyProductPage() {
        common.isDisplayed(productsElement.btn_add_product);
        common.isDisplayed(productsElement.btn_export);
        common.isDisplayed(productsElement.btn_import);
        common.isDisplayed(productsElement.btn_delete);
        common.isDisplayed(productsElement.product_name);
        common.isDisplayed(productsElement.warehouse);
        common.isDisplayed(productsElement.category);
        common.isDisplayed(productsElement.product_type);
    }

    public void clickAddProduct() {
        common.click(productsElement.btn_add_product);
    }

    public void checkPriceExpand() {
        if (common.getValueOfEleDisplay(By.xpath(productsElement.price_product_field + "//*[@class = 'card-body']")).contains("none")) {
            common.click(By.xpath(productsElement.price_product_field));
        }
    }

    public void inputInfoProduct() {
        common.sendKeys(productsElement.name, "iphone");
        common.sendKeys(productsElement.description, "nothing");
        common.sendKeys(productsElement.sku, "1234567");
        common.click(productsElement.categories);
        common.click(productsElement.books);
    }

    public void inputPriceProduct() {
        common.sendKeys(productsElement.price, "13");
        common.sendKeys(productsElement.old_price, "23");
    }

}
