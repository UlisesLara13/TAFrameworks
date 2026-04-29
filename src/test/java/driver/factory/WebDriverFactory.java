package driver.factory;

import org.openqa.selenium.WebDriver;

/**
 * Factory interface for creating WebDriver instances.
 */
public interface WebDriverFactory {
    WebDriver createDriver();
}