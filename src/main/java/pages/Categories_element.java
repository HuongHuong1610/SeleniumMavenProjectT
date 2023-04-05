package pages;

import org.openqa.selenium.By;

public class Categories_element {
    public By btn_add = By.xpath("//a[@href='/Admin/Category/Create']");
    public By btn_export = By.className("btn-group");
    public By btn_import = By.name("importexcel");
    public By btn_delete = By.id("delete-selected");

    public By name = By.xpath("//th[contains(text(),'Name')]");
    public By published = By.xpath("//th[contains(text(),'Published')]");

    public By category_name = By.id("Name");
    public By message = By.xpath("//button[@data-dismiss='alert']");

    public By btn_save = By.name("save");
}
