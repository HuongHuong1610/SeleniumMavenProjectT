package commons;

import core.BaseTest;
import core.baseTestCrossBrowser;
import org.openqa.selenium.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportNGListener implements ITestListener {
    public void onTestFailure(ITestResult result) {
        try {
            // if set = true (default) , HTML code not run
            System.setProperty("org.uncommons.reportng.escape-output", "false");

            Object testClass = result.getInstance();
            //get driver into base test
            WebDriver driver = ((baseTestCrossBrowser) testClass).getWebDriver();
            // capture
            String screenshotPath = captureScreenshot(driver, result.getName());
            // get status of testcase
            Reporter.getCurrentTestResult();
            // add to report of testNG
            Reporter.log("<br><a target=\"_blank\" href=\"data:image/png;base64," + screenshotPath + "\">" + "<img src=\"data:image/png;base64," + screenshotPath + "\" " + "height='100' width='150'/> " + "</a></br>");
            // Re set status of testcase = null
            Reporter.setCurrentTestResult(null);
        } catch (NoSuchSessionException e) {
            e.printStackTrace();
        } catch (WebDriverException e) {
            e.printStackTrace();
        }

    }
    public String captureScreenshot(WebDriver driver, String screenshotName) {
        String screenshotBase64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        return screenshotBase64;
    }
}
