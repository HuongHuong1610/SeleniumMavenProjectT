package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Function;

public class WebElementHelper extends BaseTest {

    public void isDisplayed(By by){
        log.info("Verify Element is Displayed");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
        Assert.assertTrue(element.isDisplayed());
    }

    public void sendKeys(By by, String value){
        log.info("Input value");
        wait.until(ExpectedConditions.visibilityOfElementLocated(by)).sendKeys(value);
    }
    public static String waitAndGetText(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by)).getText();
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
                //Tổng thời gian chờ cho đkien
                .withTimeout(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT))
                //Tgian lặp lại để tìm dkien chưa thỏa mãn
                .pollingEvery(Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT))
                //Hết tgian polling nếu gặp exception là ko tìm tấy element thì ignore (chọn exception theo dkien)
                .ignoring(NoSuchElementException.class);
        wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.cssSelector(".alert-success"));
            }
        });
    }

    public void switchToWindow(String expectedTitle) {
        Set<String> windows = driver.getWindowHandles();  //get all window handles
        //Find expected window
        for(String windowID : windows){
            String tittle = driver.switchTo().window(windowID).getTitle();
            if(tittle.contains(expectedTitle)){
                driver.switchTo().window(windowID);
            }
        }

//        String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
//        Set<String> handles = driver.getWindowHandles(); // get all window handles
//        //Duyệt các phần tử
//        Iterator<String> iterator = handles.iterator();
//        //Check có phần tử tiếp theo hay không > Get phần tử đó
//        while (iterator.hasNext()) {
//            String tittle = iterator.next();
//            if(!parentWindowHandler.equals(tittle)) {
//                driver.switchTo().window(tittle);
//                System.out.println(driver.switchTo().window(tittle).getTitle());
//                driver.close();
//            }
//        }
//        driver.switchTo().window(parentWindowHandler);
    }

    public String getValueOfEleDisplay(By by) {
        String result = wait.until(ExpectedConditions.presenceOfElementLocated(by)).getCssValue("display");
        log.info("Value: " + result);
        return result;
    }
}
