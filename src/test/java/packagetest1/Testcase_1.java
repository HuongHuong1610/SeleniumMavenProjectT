package packagetest1;

import core.ExcelUtils;
import core.BaseTest;
import core.GlobalConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.*;

public class Testcase_1 extends BaseTest {
    Log_TCs log_tCs = new Log_TCs();
    Dashboard_TCs dashboard_tCs = new Dashboard_TCs();
    Categories_TCs categories_tCs = new Categories_TCs();
    Products_TCs products_tCs = new Products_TCs();

    @DataProvider()
    public Object[][] getData(){
        String path = GlobalConstants.PROJECT_PATH + "\\src\\main\\resources\\LoginData.xlsx";
        log.info("get data on excel");
        ExcelUtils excel = new ExcelUtils();
        Object data[][] = excel.getTestData("data", path);
        return data;
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCategory(String email, String pwd) {
        log.info("Step1 :Login");

        log_tCs.login_success(email, pwd);
        log.info("Verify Categories Page");
        dashboard_tCs.navigate_CategoriesPage();
        categories_tCs.verify_CategoriesPage();

        log.info("step2 : Click button Add new");
        categories_tCs.click_add();

        log.info("Step3 : Input Category Name");
        categories_tCs.input_Categoryname();

        log.info("Step4 : Click button Save & verify message");
        categories_tCs.click_save();

        log.info("Step5 : Log out");
        log_tCs.closeAlert();
        //Log out
        log_tCs.logout();
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCustomer(String email, String pwd) {
        log.info("Step1 :Login");
        log_tCs.login_success(email, pwd);

        log.info("Verify Product Page");
        dashboard_tCs.navigate_ProductPage();
        products_tCs.verify_Productpage();

        log.info("Step 2: Click button Add new");
        products_tCs.click_add();

        log.info("Step3: Input Product Name, description, SKU, Categories, Price, Old price");
        products_tCs.input();

        log.info("Step 4: Input Product Name, description, SKU, Categories, Price, Old price");
        products_tCs.click_save();

        log.info("Step5: logout");
        log_tCs.logout();
    }

}
