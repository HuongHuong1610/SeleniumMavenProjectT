package commons;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.GlobalConstants;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements IReporter {
    private ExtentReports extent;
    private ExtentHtmlReporter htmlReport;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        htmlReport = new ExtentHtmlReporter(GlobalConstants.PROJECT_PATH + "\\htmlExtent\\ExtentReportV2.html");
        htmlReport.config().setTheme(Theme.DARK);
        htmlReport.config().setDocumentTitle("Test Demo Automation Selenium");
        htmlReport.config().setReportName("Functional UI");
        htmlReport.config().setEncoding("utf-8");
        extent = new ExtentReports();
        extent.attachReporter(htmlReport);

        for (ISuite suite : suites) {
            Map<String, ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);
            }
        }

        for (String s : Reporter.getOutput()) {
            s = s + "<br>";
            extent.setTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName());

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group);

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable());
                } else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
