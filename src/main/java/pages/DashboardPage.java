package pages;

import util.DashboardUtil;

public class DashboardPage {
    DashboardUtil dashboardElement =new DashboardUtil();
    Common common = new Common();

    public void navigate_CategoriesPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.categories);
    }

    public void navigate_ProductPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.product);
    }

    public void navigate_CustomerRolesPage() {
        common.click(dashboardElement.customers);
        common.click(dashboardElement.customer_roles);
    }
}
