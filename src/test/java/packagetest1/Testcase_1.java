package packagetest1;

import core.ExcelHelper;
import core.BaseTest;
import core.GlobalConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class Testcase_1 extends BaseTest {
    LogInPage logInPage = new LogInPage();
    DashboardPage dashboardPage = new DashboardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    ProductsPage productsPage = new ProductsPage();
    CustomerRolesPage customerRolesPage = new CustomerRolesPage();

    @DataProvider()
    public Object[][] getData(){
        String path = GlobalConstants.PROJECT_PATH + "\\src\\main\\resources\\LoginData.xlsx";
        log.info("get data on excel");
        ExcelHelper excel = new ExcelHelper();
        Object data[][] = excel.getTestData("data", path);
        return data;
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCategory(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.login_success(email, pwd);

        log.info("Verify Categories Page");
        dashboardPage.navigate_CategoriesPage();
        categoriesPage.verifyCategoriesPage();

        log.info("step2 : Click button Add new");
        categoriesPage.clickAdd();

        log.info("Step3 : Input Category Name");
        categoriesPage.inputCategoryName();

        log.info("Step4 : Click button Save & verify message");
        categoriesPage.clickSave();

        log.info("Step5 : Log out");
        logInPage.closeAlert();
        logInPage.logout();
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCustomer(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.login_success(email, pwd);

        log.info("Verify Product Page");
        dashboardPage.navigate_ProductPage();
        productsPage.verify_Productpage();

        log.info("Step 2: Click button Add new");
        productsPage.click_add();

        log.info("Step3: Input Product Name, description, SKU, Categories, Price, Old price");
        productsPage.input();

        log.info("Step 4: Input Product Name, description, SKU, Categories, Price, Old price");
        productsPage.click_save();

        log.info("Step5: logout");
        logInPage.logout();
    }

    @Test(dataProvider = "getData")
    public void TC_VerifyProduct(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.login_success(email, pwd);
        dashboardPage.navigate_CustomerRolesPage();

        log.info("Step 2: Choose a product");
        customerRolesPage.click_edit("Guests");

        log.info("Step3: Verify product info");
        customerRolesPage.clickBtnChooseProduct();
        customerRolesPage.switchToWindow("Choose a product");
        customerRolesPage.selectProduct(0);
        customerRolesPage.switchToWindow("Edit customer role details");
        customerRolesPage.click_save();
        customerRolesPage.clickBtnChooseProduct();

        log.info("Step5 : Log out");
        logInPage.logout();
    }
}
