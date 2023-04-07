package tests;

import core.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class Common extends BaseTest {
    //Verify Element is Displayed
    public void isDisplayed(By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed());
    }

    // senKeys to Element
    public void sendKeys(By by, String value){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.sendKeys(value);
    }

    //Click a Element
    public void click(By by){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.click();
    }

    //Clear Element
    public void clear(By by) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        element.clear();
    }

}
