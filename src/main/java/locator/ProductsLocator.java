package locator;

import org.openqa.selenium.By;

public class ProductsLocator extends AbstractPageLocator {
    public By product_name = By.xpath("//label[contains(text(),'Product name')]");
    public By warehouse = By.xpath("//label[contains(text(),'Warehouse')]");
    public By category = By.xpath("//label[contains(text(),'Category')]");
    public By product_type = By.xpath("//label[contains(text(),'Product type')]");

    public By description = By.id("ShortDescription");
    public By sku = By.id("Sku");

    public By categories = By.xpath("//input[@aria-labelledby='SelectedCategoryIds_label']");
    public By books = By.xpath("//li[contains(text(),'Books')]");

    public By price = By.xpath("//input[@id='Price']//preceding-sibling::input");
    public By old_price = By.xpath("//input[@id='OldPrice']//preceding-sibling::input");
    public String price_product_field = "//*[@data-card-name = 'product-price']";

}
