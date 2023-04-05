package tests;

import pages.Dashboard_element;

public class Dashboard_TCs {
    Dashboard_element dashboardElement =new Dashboard_element();
    Common common = new Common();

    public void navigate_CategoriesPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.categories);
    }

    public void navigate_ProductPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.product);
    }
}
