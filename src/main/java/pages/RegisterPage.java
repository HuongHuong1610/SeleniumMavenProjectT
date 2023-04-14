package pages;

import core.WebElementHelper;
import org.openqa.selenium.By;

import static locator.RegisterLocator.*;
import static org.testng.Assert.assertTrue;

public class RegisterPage extends AbstractPage {
    public RegisterPage createNewAccount(String firstName, String lastName, String email, String passWord, String confirmPassword) {
        webElementHelper.sendKeys(FIRST_NAME, firstName);
        webElementHelper.sendKeys(LAST_NAME, lastName);
        webElementHelper.sendKeys(EMAIL, email);
        webElementHelper.sendKeys(PASSWORD, passWord);
        webElementHelper.sendKeys(CONFIRM_PASSWORD, confirmPassword);
        webElementHelper.click(REGISTER_BUTTON);
        return this;
    }
    public RegisterPage verifyCreateNewAccountSuccessfully(String expectedMessage){
        String actualMessage = WebElementHelper.waitAndGetText(MESSAGE_SUCCESS);
        assertTrue(actualMessage.contains(expectedMessage), String.format("Expected Message is [%s] but actual message is [%s]",expectedMessage,actualMessage));
        return this;
    }

}
