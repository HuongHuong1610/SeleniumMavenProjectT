package core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected Log log;
    public BaseTest() {
        log = LogFactory.getLog(getClass());
    }
    @BeforeMethod
    public void setup() {
        String url = "https://admin-demo.nopcommerce.com/login";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
    }
    @AfterMethod()
    public void afterClass() {
        driver.quit();
    }
    public static int random(){
        Random rand = new Random();
        return rand.nextInt(99999);
    }
}
