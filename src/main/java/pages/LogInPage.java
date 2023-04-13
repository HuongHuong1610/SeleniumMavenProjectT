package pages;

import util.DashboardUtil;
import util.LoginPageUtil;

public class LogInPage extends AbstractPage {
    LoginPageUtil loginPageElement = new LoginPageUtil();
    DashboardUtil dashboardElement = new DashboardUtil();

    public void loginSuccess(String email, String pwd) {
        webElementHelper.clear(loginPageElement.email);
        webElementHelper.sendKeys(loginPageElement.email, email);
        webElementHelper.clear(loginPageElement.password);
        webElementHelper.sendKeys(loginPageElement.password, pwd);
        webElementHelper.click(loginPageElement.btn_login);
        webElementHelper.isDisplayed(dashboardElement.menu);
    }

    public void login_valid() {
        webElementHelper.sendKeys(loginPageElement.email, "super");
        webElementHelper.sendKeys(loginPageElement.password, "admin");
        webElementHelper.click(loginPageElement.btn_login);
    }

    public void closeAlert() {
        webElementHelper.click(loginPageElement.btn_alert);
    }

    public void logOut() {
        webElementHelper.click(loginPageElement.btn_logout);
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
