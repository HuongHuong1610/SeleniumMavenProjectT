package pages;

import org.openqa.selenium.By;

public class Dashboard_element {
    public By menu = By.className("os-content");
    public By catalog = By.xpath("//a[@href='#']//p[contains(text(), 'Catalog')]");
    public By categories = By.xpath("//p[contains(text(),'Categories')]");
    public By product = By.xpath("//a[@href='/Admin/Product/List']");
}
