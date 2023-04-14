package locator;

import org.openqa.selenium.By;

public class RegisterLocator extends AbstractPageLocator {
    public static final By FIRST_NAME = By.id("FirstName");
    public static final By LAST_NAME = By.id("LastName");
    public static final By EMAIL = By.id("Email");
    public static final By PASSWORD = By.id("Password");
    public static final By CONFIRM_PASSWORD = By.id("ConfirmPassword");
    public static final By REGISTER_BUTTON = By.id("register-button");
    public static final By MESSAGE_SUCCESS = By.cssSelector(".page-body .result");
}
