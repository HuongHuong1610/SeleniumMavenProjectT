package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class WebBase {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void setup() {
        String url = "https://admin-demo.nopcommerce.com/login";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


}
