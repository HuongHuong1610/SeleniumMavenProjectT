package tests;

import core.BaseTest;
import core.GlobalConstants;
import core.baseTestCrossBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class Common extends BaseTest {

    public void isDisplayed(By by){
        log.info("Verify Element is Displayed");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed());
    }

    public void sendKeys(By by, String value){
        log.info("Input value");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
    }

    public void click(By by){
        log.info("Click button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).click();
    }

    public void clear(By by) {
        log.info("Clear value");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).clear();
    }

    public List<WebElement> findElements(By by) {
        log.info("Find list of elements");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).findElements(by);
    }

    public void waitForMessageDisplayed() {
        FluentWait wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver ) {
                return driver.findElement(By.cssSelector(".alert-success"));
            }
        });
    }

}
