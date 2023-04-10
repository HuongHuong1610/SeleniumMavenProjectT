package pages;

import util.CategoriesUtil;

public class CategoriesPage extends AbstractPage {
    CategoriesUtil categoriesElement = new CategoriesUtil();
    Common common = new Common();

    public void verifyCategoriesPage() {
        common.isDisplayed(categoriesElement.btn_add_categories);
        common.isDisplayed(categoriesElement.btn_export);
        common.isDisplayed(categoriesElement.btn_import);
        common.isDisplayed(categoriesElement.btn_delete);
        common.isDisplayed(categoriesElement.category_name);
        common.isDisplayed(categoriesElement.published);
    }

    public void clickAddCategory() {
        common.click(categoriesElement.btn_add_categories);
    }

    public void inputCategoryName() {
        common.sendKeys(categoriesElement.name, "test");
    }

}
