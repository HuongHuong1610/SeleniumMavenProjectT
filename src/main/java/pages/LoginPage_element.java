package pages;

import org.openqa.selenium.By;

public class LoginPage_element {
    public By email = By.id("Email");
    public By password = By.id("Password");

    public By btn_login = By.xpath("//button[contains(text(),'Log in')]");
    public By btn_logout = By.xpath("//button[@data-dismiss='alert']");
}
