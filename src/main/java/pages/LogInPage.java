package pages;

import util.DashboardUtil;
import util.LoginPageUtil;

public class LogInPage {
    LoginPageUtil loginPageElement = new LoginPageUtil();
    DashboardUtil dashboardElement = new DashboardUtil();
    Common common = new Common();

    public void loginSuccess(String email, String pwd) {
        common.clear(loginPageElement.email);
        common.sendKeys(loginPageElement.email, email);
        common.clear(loginPageElement.password);
        common.sendKeys(loginPageElement.password, pwd);
        common.click(loginPageElement.btn_login);
        common.isDisplayed(dashboardElement.menu);
    }

    public void login_valid() {
        common.sendKeys(loginPageElement.email, "super");
        common.sendKeys(loginPageElement.password, "admin");
        common.click(loginPageElement.btn_login);
    }

    public void closeAlert() {
        common.click(loginPageElement.btn_alert);
    }

    public void logOut() {
        common.click(loginPageElement.btn_logout);
    }




//    public void selectBook() {
//        common.click(homepageElement.btn_all);
//        common.selectedByIndex(homepageElement.selectOption, 5);
//    }

//    public void verifyItemTitle(String product_title) {
//        String title = common.getText(homepageElement.item_title);
//        Assert.assertEquals(title, product_title);
//    }

}
