package utils;

import driver.DriverSingleton;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for taking screenshots during test execution.
 * It provides a method to take screenshots for failed tests, saving them in the "screenshots" directory with a timestamped filename.
 */
public class ScreenshotUtils {

    private static final Logger log = LogManager.getLogger(ScreenshotUtils.class);
    private static final String SCREENSHOT_DIR = "screenshots";

    private ScreenshotUtils() {}

    /**
     * Takes a screenshot of the current browser state and saves it to the "screenshots" directory.
     * The filename is formatted as <testName>_<timestamp>.png.
     *
     * @param testName the name of the test method, used to name the screenshot file
     * @return the absolute path to the saved screenshot, or null if an error occurred
     */
    public static String takeScreenshot(String testName) {
        WebDriver driver = DriverSingleton.getDriver();
        if (driver == null) {
            log.error("Cannot take screenshot: WebDriver is null");
            return null;
        }

        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
            String fileName = testName + "_" + timestamp + ".png";
            Path screenshotDir = Paths.get(SCREENSHOT_DIR);

            if (!Files.exists(screenshotDir)) {
                Files.createDirectories(screenshotDir);
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Path destPath = screenshotDir.resolve(fileName);
            Files.copy(srcFile.toPath(), destPath);

            String absolutePath = destPath.toAbsolutePath().toString();
            log.info("Screenshot saved: {}", absolutePath);
            return absolutePath;

        } catch (IOException e) {
            log.error("Failed to save screenshot for test: {}", testName, e);
            return null;
        }
    }
}
