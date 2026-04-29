package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import decorator.BaseElementActions;
import decorator.ElementActions;
import decorator.LoggingDecorator;

import java.time.Duration;

/**
 * Abstract class representing a generic web page.
 * Provides common methods for interacting with web elements.
 */
public abstract class BasePage {

    /** WebDriver instance for interacting with the web browser */
    protected WebDriver driver;

    /** ElementActions instance for performing actions on web elements with logging and highlighting */
    private ElementActions actions;

    /** WebDriverWait instance for explicit waits */
    protected WebDriverWait wait;

    /** Timeout duration for waits in seconds */
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    /** Constructor initializes WebDriver, WebDriverWait, and ElementActions with logging */
    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
        this.actions = new LoggingDecorator(
                new BaseElementActions(driver),
                driver
        );
    }



    /** Abstract method to open the specific page */
    protected abstract BasePage openPage();

    /** Waits for the visibility of a web element */
    protected void waitForVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /** Waits for a web element to be clickable */
    protected void waitForClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /** Clicks on a web element after waiting for it to be clickable */
    protected void clickElement(WebElement element) {
        actions.click(element);
    }

    /** Types text into a web element after waiting for its visibility */
    protected void typeText(WebElement element, String text) {
        actions.type(element, text);
    }

    /** Highlights a web element by adding a red border around it using JavaScript */
    protected void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].style.border='3px solid red'", element
        );
    }

    /** Retrieves and trims the text from a web element after waiting for its visibility */
    protected String getText(WebElement element) {
        waitForVisibility(element);
        return element.getText().trim();
    }
}
