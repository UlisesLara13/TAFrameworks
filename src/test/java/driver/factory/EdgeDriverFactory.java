package driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

/**
 * Factory class for creating Edge WebDriver instances.
 */
public class EdgeDriverFactory implements WebDriverFactory {

    @Override
    public WebDriver createDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}