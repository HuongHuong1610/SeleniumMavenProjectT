package core;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class baseTestCrossBrowser {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected Log log;


    public baseTestCrossBrowser() {
        log = LogFactory.getLog(getClass());
    }
    @Parameters("browser")
    @BeforeMethod
    protected WebDriver setup(String browserName) {
        switch (browserName) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not  valid");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        driver.manage().window().maximize();
        driver.get(GlobalConstants.AUTOMATION_URL);
        return driver;
    }

    @AfterMethod
    public void afterClass() {
        driver.quit();
    }
    public WebDriver getWebDriver(){
        return this.driver;
    }
}
