package tests;

import pages.Categories_element;

public class Categories_TCs {
    Categories_element categoriesElement = new Categories_element();
    Common common = new Common();

    public void verify_CategoriesPage() {
        common.isDisplayed(categoriesElement.btn_add);
        common.isDisplayed(categoriesElement.btn_export);
        common.isDisplayed(categoriesElement.btn_import);
        common.isDisplayed(categoriesElement.btn_delete);
        common.isDisplayed(categoriesElement.name);
        common.isDisplayed(categoriesElement.published);
    }

    public void click_add() {
        common.click(categoriesElement.btn_add);
    }

    public void input_Categoryname() {
        common.sendKeys(categoriesElement.category_name, "test");
    }

    public void click_save() {
        common.click(categoriesElement.btn_save);
        common.isDisplayed(categoriesElement.message);
    }

}
