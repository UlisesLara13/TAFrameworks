package driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Factory class for creating Chrome WebDriver instances.
 */
public class ChromeDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}