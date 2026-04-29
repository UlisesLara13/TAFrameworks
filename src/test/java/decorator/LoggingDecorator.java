package decorator;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Decorator class that adds logging and highlighting functionality to ElementActions.
 */
public class LoggingDecorator implements ElementActions {

    private ElementActions actions;
    private WebDriver driver;

    /** Constructor initializes the wrapped ElementActions and WebDriver */
    public LoggingDecorator(ElementActions actions, WebDriver driver) {
        this.actions = actions;
        this.driver = driver;
    }

    /** Clicks on a web element with logging and highlighting */
    @Override
    public void click(WebElement element) {
        highlight(element);
        System.out.println("Clicking element: " + element);
        actions.click(element);
    }

    /** Types text into a web element with logging and highlighting */
    @Override
    public void type(WebElement element, String text) {
        highlight(element);
        System.out.println("Typing: " + text);
        actions.type(element, text);
    }

    /** Highlights a web element by adding a red border around it using JavaScript */
    private void highlight(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}