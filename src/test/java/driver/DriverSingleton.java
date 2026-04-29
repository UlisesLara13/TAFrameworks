package driver;

import org.openqa.selenium.WebDriver;
import service.TestDataReader;
import driver.factory.ChromeDriverFactory;
import driver.factory.EdgeDriverFactory;
import driver.factory.WebDriverFactory;

/**
 * Singleton class to manage WebDriver instances.
 * Uses ThreadLocal to ensure thread safety for parallel test execution.
 */
public class DriverSingleton {
    /** ThreadLocal to hold WebDriver instances for each thread */
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Returns the WebDriver instance for the current thread.
     *
     * Uses ThreadLocal to support parallel execution.
     * Chooses the browser based on the system property "browser" (default is "chrome").
     * Sets up the corresponding driver with WebDriverManager.
     * Maximizes the browser window upon startup.
     */
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            String browser = TestDataReader.getTestData("browser");

            WebDriverFactory factory;

            switch (browser.toLowerCase()) {
                case "edge":
                    factory = new EdgeDriverFactory();
                    break;
                case "chrome":
                default:
                    factory = new ChromeDriverFactory();
                    break;
            }

            driver.set(factory.createDriver());
            driver.get().manage().window().maximize();
        }

        return driver.get();
    }

    /**
     * Closes the WebDriver instance for the current thread and removes it from ThreadLocal.
     */
    public static void closeDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
