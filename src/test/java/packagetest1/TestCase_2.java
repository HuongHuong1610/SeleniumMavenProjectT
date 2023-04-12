package packagetest1;

import core.BaseTest;
import core.ExcelHelper;
import core.GlobalConstants;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.CategoriesPage;
import pages.DashboardPage;
import pages.LogInPage;

public class TestCase_2 extends BaseTest {
    LogInPage logInPage = new LogInPage();
    DashboardPage dashboardPage = new DashboardPage();
    CategoriesPage categoriesPage = new CategoriesPage();
    private static String name;

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
        logInPage.loginSuccess(email, pwd);
        log.info("Verify Categories Page");
        dashboardPage.navigateCategoriesPage();
        categoriesPage.verifyCategoriesPage();

        log.info("step2 : Click button Add new");
        categoriesPage.clickAddCategory();

        log.info("Step3 : Input Category Name");
        name = "Phone";
        categoriesPage.inputCategoryName(name);

        log.info("Step4 : Click button Save & verify message");
        categoriesPage.clickSave();

        log.info("Step5 : Log out");
        logInPage.logOut();
    }

    @Test(dataProvider = "getData")
    public void TC_SearchCategory(String email, String pwd) {
        log.info("Step1 :Login");
        logInPage.loginSuccess(email, pwd);
        log.info("Verify Categories Page");
        dashboardPage.navigateCategoriesPage();

        log.info("step2 : Verify category displayed");
        categoriesPage.searchCategoryByName(name);
        categoriesPage.verifyCateDisplayed(name);

        log.info("Step3 : Input Category Name");
        categoriesPage.clickAddCategory();
        name = "test";
        categoriesPage.inputCategoryName(name);

        log.info("Step4 : Click button Save & verify message");
        categoriesPage.clickSave();
        categoriesPage.verifyCateDisplayed(name);

        log.info("Step5 : Log out");
        logInPage.logOut();
    }
}
