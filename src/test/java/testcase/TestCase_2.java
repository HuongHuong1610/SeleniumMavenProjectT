package testcase;

import core.ExcelUtils;
import core.GlobalConstants;
import core.baseTestCrossBrowser;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.Categories_TCs;
import tests.Dashboard_TCs;
import tests.Log_TCs;

public class TestCase_2 extends baseTestCrossBrowser {
    Log_TCs log_tCs = new Log_TCs();
    Dashboard_TCs dashboard_tCs = new Dashboard_TCs();
    Categories_TCs categories_tCs = new Categories_TCs();
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
        log_tCs.logout();
    }
}
