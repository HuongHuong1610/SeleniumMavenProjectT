package packagetest2;

import commons.PropertiesFile;
import core.BaseTest;
import org.testng.annotations.Test;
import pages.LogInPage;
import pages.RegisterPage;

import core.baseTestCrossBrowser;


public class demoTestNGLoop extends BaseTest {
    private static final String PASSWORD = "Huong@12345";
    private static final String MESSAGE = "Your registration completed";

    @Test(invocationCount = 1)
    public void TC_01_CreateNewCategory() {
        log.info("Step1 :Login");
        LogInPage logInPage = new LogInPage();
        PropertiesFile.setPropertiesFile();
        String email = PropertiesFile.getPropValue("email.login.error");
        String pwd = PropertiesFile.getPropValue("password.login.error");
        PropertiesFile.setPropValue("test","huong");
        logInPage.loginSuccess(email, pwd);

        log.info("Navigate lại vào link này để test phần loop register");
        driver.get("https://demo.nopcommerce.com/register");
        RegisterPage registerPage = new RegisterPage();
        String firstName = "Huong" + random();
        String lastName = "Vu" + random();
        String mail = "HuongHuong" + random() + "@gmail.com";
        log.info(String.format("firstName is: [%s], lastName is: [%s], email is [%s]",firstName,lastName,mail));
        registerPage.createNewAccount(firstName, lastName, mail, PASSWORD, PASSWORD);
        registerPage.verifyCreateNewAccountSuccessfully(MESSAGE);
    }
}
