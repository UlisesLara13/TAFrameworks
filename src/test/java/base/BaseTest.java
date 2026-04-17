package base;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import service.TestDataReader;
import utils.ScreenshotUtils;

/**
 * BaseTest class that serves as a parent for all test classes.
 * It manages the WebDriver lifecycle and provides common setup and teardown methods.
 */
public class BaseTest {

    protected final Logger log = LogManager.getLogger(getClass());
    protected WebDriver driver;

    /**
     * Sets up the WebDriver before each test method.
     * Navigates to the base URL of the application.
     */
    @BeforeMethod
    public void setUp(java.lang.reflect.Method method) {
        log.info("========== STARTING TEST: {} ==========", method.getName());
        driver = DriverSingleton.getDriver();
        driver.get(TestDataReader.getTestData("base.url"));
        log.info("Navigating to: {}", TestDataReader.getTestData("base.url"));
    }

    /**
     * Tears down the WebDriver after each test method.
     * If the test fails, it takes a screenshot of the error.
     *
     * @param result the result of the test method execution
     */
    @AfterMethod
    public void tearDown(ITestResult result) {
        String testName = result.getName();

        if (result.getStatus() == ITestResult.SUCCESS) {
            log.info("TEST PASSED: {}", testName);

        } else if (result.getStatus() == ITestResult.FAILURE) {
            log.error("TEST FAILED: {}", testName);
            log.error("Cause: {}", result.getThrowable().getMessage());

            String path = ScreenshotUtils.takeScreenshot(testName);

            log.error("Screenshot saved at: {}", path);

        } else if (result.getStatus() == ITestResult.SKIP) {
            log.warn("TEST SKIPPED: {}", testName);
        }

        log.info("========== END TEST: {} ==========\n", testName);
        DriverSingleton.closeDriver();
    }
}
