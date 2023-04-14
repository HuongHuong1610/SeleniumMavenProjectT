package pages;

import org.openqa.selenium.By;
import locator.CategoriesLocator;

public class CategoriesPage extends AbstractPage {
    CategoriesLocator categoriesElement = new CategoriesLocator();

    public void verifyCategoriesPage() {
        webElementHelper.isDisplayed(categoriesElement.btn_add_categories);
        webElementHelper.isDisplayed(categoriesElement.btn_export);
        webElementHelper.isDisplayed(categoriesElement.btn_import);
        webElementHelper.isDisplayed(categoriesElement.btn_delete);
        webElementHelper.isDisplayed(categoriesElement.category_name);
        webElementHelper.isDisplayed(categoriesElement.published);
    }

    public void clickAddCategory() {
        webElementHelper.click(categoriesElement.btn_add_categories);
    }

    public void inputCategoryName(String name) {
        webElementHelper.sendKeys(categoriesElement.name, name);
    }

    public void searchCategoryByName(String name) {
        webElementHelper.sendKeys(categoriesElement.category_name, name);
    }

    public void verifyCateDisplayed(String name) {
        webElementHelper.isDisplayed(By.xpath("//table[@id = 'categories-grid']/././/td[contains(text(), '" + name + "')]"));
    }
}
