package pages;

import util.DashboardUtil;

public class DashboardPage extends AbstractPage {
    DashboardUtil dashboardElement =new DashboardUtil();

    public void navigateCategoriesPage() {
        webElementHelper.click(dashboardElement.catalog);
        webElementHelper.click(dashboardElement.categories);
    }

    public void navigateProductPage() {
        webElementHelper.click(dashboardElement.catalog);
        webElementHelper.click(dashboardElement.product);
    }

    public void navigateCustomerRolesPage() {
        webElementHelper.click(dashboardElement.customers);
        webElementHelper.click(dashboardElement.customer_roles);
    }
}
