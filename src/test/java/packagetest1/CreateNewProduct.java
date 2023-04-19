package packagetest1;

import commons.PropertiesFile;
import core.ExcelHelper;
import core.BaseTest;
import core.GlobalConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class CreateNewProduct extends BaseTest {
    LogInPage logInPage = new LogInPage();
    DashboardPage dashboardPage = new DashboardPage();
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

    //expect input from method getData
    @Test(dataProvider = "getData")
    public void TC_04_CreateNewProduct(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.loginSuccess(email, pwd);

        log.info("Verify Product Page");
        dashboardPage.navigateProductPage();
        productsPage.checkSearchExpand();
        productsPage.verifyProductPage();

        log.info("Step 2: Click button Add new");
        productsPage.clickAddProduct();

        log.info("Step3: Input Product Name, description, SKU, Categories, Price, Old price");
        productsPage.checkInfoProdFieldExpand();
        productsPage.inputInfoProduct();
        productsPage.checkPriceExpand();
        productsPage.inputPriceProduct();

        log.info("Step 4: Input Product Name, description, SKU, Categories, Price, Old price");
        productsPage.clickSave();

        log.info("Step5: logout");
        logInPage.logOut();
    }

    @Test(dataProvider = "getData")
    public void TC_02_VerifyProduct(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.loginSuccess(email, pwd);
        dashboardPage.navigateCustomerRolesPage();

        log.info("Step 2: Choose a product");
        customerRolesPage.clickEdit("Guests");

        log.info("Step3: Verify product info");
        customerRolesPage.clickBtnChooseProduct();
        customerRolesPage.switchToWindow("Choose a product");
        customerRolesPage.selectProduct(0);
        customerRolesPage.switchToWindow("Edit customer role details");
        customerRolesPage.clickSave();
        customerRolesPage.clickBtnChooseProduct();

        log.info("Step5 : Log out");
        logInPage.logOut();
    }
    @Test(enabled = false)
    public void TC_05_ReadDataFromPropertiesFile() {
        log.info("Step1 :Login");
        PropertiesFile.setPropertiesFile();
        String email = PropertiesFile.getPropValue("email.login.error");
        String pwd = PropertiesFile.getPropValue("password.login.error");
        logInPage.loginSuccess(email, pwd);
    }
}
