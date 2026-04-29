package decorator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base implementation of ElementActions that provides basic click and type functionalities.
 * It uses WebDriverWait to ensure elements are interactable before performing actions.
 */
public class BaseElementActions implements ElementActions {

    private WebDriver driver;
    private WebDriverWait wait;

    /** Constructor initializes WebDriver and WebDriverWait */
    public BaseElementActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /** Clicks on a web element after waiting for it to be clickable */
    @Override
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /** Types text into a web element after waiting for it to be visible */
    @Override
    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }
}