package pages;

import org.openqa.selenium.By;
import locator.ProductsLocator;

public class ProductsPage extends AbstractPage {
    ProductsLocator productsElement = new ProductsLocator();

    public void verifyProductPage() {
        webElementHelper.isDisplayed(productsElement.btn_add_product);
        webElementHelper.isDisplayed(productsElement.btn_export);
        webElementHelper.isDisplayed(productsElement.btn_import);
        webElementHelper.isDisplayed(productsElement.btn_delete);
        webElementHelper.isDisplayed(productsElement.product_name);
        webElementHelper.isDisplayed(productsElement.warehouse);
        webElementHelper.isDisplayed(productsElement.category);
        webElementHelper.isDisplayed(productsElement.product_type);
    }

    public void clickAddProduct() {
        webElementHelper.click(productsElement.btn_add_product);
    }

    public void checkPriceExpand() {
        if (webElementHelper.getValueOfEleDisplay(By.xpath(productsElement.price_product_field + "//*[@class = 'card-body']")).contains("none")) {
            webElementHelper.click(By.xpath(productsElement.price_product_field));
        }
    }

    public void inputInfoProduct() {
        webElementHelper.sendKeys(productsElement.name, "iphone");
        webElementHelper.sendKeys(productsElement.description, "nothing");
        webElementHelper.sendKeys(productsElement.sku, "1234567");
        webElementHelper.click(productsElement.categories);
        webElementHelper.click(productsElement.books);
    }

    public void inputPriceProduct() {
        webElementHelper.sendKeys(productsElement.price, "13");
        webElementHelper.sendKeys(productsElement.old_price, "23");
    }

}
