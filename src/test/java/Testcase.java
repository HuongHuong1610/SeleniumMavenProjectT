import core.ExcelUtils;
import core.WebBase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.*;

import java.io.IOException;

public class Testcase extends WebBase {
    Log_TCs log_tCs = new Log_TCs();
    Dashboard_TCs dashboard_tCs = new Dashboard_TCs();
    Categories_TCs categories_tCs = new Categories_TCs();
    Products_TCs products_tCs = new Products_TCs();

    @DataProvider()
    public Object[][] getData() throws IOException {
        String path = "C:\\Users\\LTS\\Documents\\New folder\\Selenium_Final\\Selenium_Final\\src\\main\\resources\\LoginData.xlsx";
        // get data on excel
        ExcelUtils excel = new ExcelUtils();
        Object data[][] = excel.getTestData("data", path);
        return data;
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCategory(String email, String pwd) {
        //Login success
        log_tCs.login_success(email, pwd);
        //Verify Categories Page
        dashboard_tCs.navigate_CategoriesPage();
        categories_tCs.verify_CategoriesPage();
        //Click button Add new
        categories_tCs.click_add();
        //Input Category Name
        categories_tCs.input_Categoryname();
        //Click button Save & verify message
        categories_tCs.click_save();
        //Log out
        log_tCs.logout();
    }

    @Test(dataProvider = "getData")
    public void TC_CreateNewCustomer(String email, String pwd) {
        //Login success
        log_tCs.login_success(email, pwd);
        //Verify Product Page
        dashboard_tCs.navigate_ProductPage();
        products_tCs.verify_Productpage();
        //Click button Add new
        products_tCs.click_add();
        //Input Product Name, description, SKU, Categories, Price, Old price
        products_tCs.input();
        //Click button Save & verify message
        products_tCs.click_save();
        //Log out
        log_tCs.logout();
    }

}
