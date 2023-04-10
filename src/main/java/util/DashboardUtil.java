package util;

import org.openqa.selenium.By;

public class DashboardUtil {
    public By menu = By.className("os-content");
    public By catalog = By.xpath("//a[@href='#']//p[contains(text(), 'Catalog')]");
    public By categories = By.xpath("//p[contains(text(),'Categories')]");
    public By product = By.xpath("//a[@href='/Admin/Product/List']");
    public By customers = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
    public By customer_roles = By.xpath("//p[contains(text(),'Customer roles')]");

}
