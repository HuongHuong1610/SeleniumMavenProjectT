package pages;

import util.CategoriesUtil;

public class CategoriesPage {
    CategoriesUtil categoriesElement = new CategoriesUtil();
    Common common = new Common();

    public void verifyCategoriesPage() {
        common.isDisplayed(categoriesElement.btn_add);
        common.isDisplayed(categoriesElement.btn_export);
        common.isDisplayed(categoriesElement.btn_import);
        common.isDisplayed(categoriesElement.btn_delete);
        common.isDisplayed(categoriesElement.name);
        common.isDisplayed(categoriesElement.published);
    }

    public void clickAdd() {
        common.click(categoriesElement.btn_add);
    }

    public void inputCategoryName() {
        common.sendKeys(categoriesElement.category_name, "test");
    }

    public void clickSave() {
        common.click(categoriesElement.btn_save);
        common.isDisplayed(categoriesElement.message);
    }

}
