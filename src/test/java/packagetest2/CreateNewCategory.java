package packagetest2;

import core.ExcelHelper;
import core.GlobalConstants;
import core.baseTestCrossBrowser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LogInPage;
import pages.ProductsPage;

public class CreateNewCategory extends baseTestCrossBrowser {
    LogInPage logInPage = new LogInPage();
    DashboardPage dashboardPage = new DashboardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    ProductsPage productsPage = new ProductsPage();

    @DataProvider()
    public Object[][] getData() {
        String path = GlobalConstants.PROJECT_PATH + "\\src\\main\\resources\\LoginData.xlsx";
        log.info("get data on excel");
        ExcelHelper excel = new ExcelHelper();
        Object data[][] = excel.getTestData("data", path);
        return data;
    }

    @Test(dataProvider = "getData")
    public void TC_01_CreateNewCategory(String email, String pwd) {
        log.info("Step1 :Login");

        logInPage.loginSuccess(email, pwd);
        log.info("Verify Categories Page");
        dashboardPage.navigateCategoriesPage();
        categoriesPage.verifyCategoriesPage();

        log.info("step2 : Click button Add new");
        categoriesPage.clickAddCategory();

        log.info("Step3 : Input Category Name");
        categoriesPage.inputCategoryName("test");

        log.info("Step4 : Click button Save & verify message");
        categoriesPage.clickSave();

        log.info("Step5 : Log out");
        logInPage.logOut();
    }

}
