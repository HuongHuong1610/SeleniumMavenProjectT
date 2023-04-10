package pages;

import util.DashboardUtil;

public class DashboardPage {
    DashboardUtil dashboardElement =new DashboardUtil();
    Common common = new Common();

    public void navigateCategoriesPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.categories);
    }

    public void navigateProductPage() {
        common.click(dashboardElement.catalog);
        common.click(dashboardElement.product);
    }

    public void navigateCustomerRolesPage() {
        common.click(dashboardElement.customers);
        common.click(dashboardElement.customer_roles);
    }
}
