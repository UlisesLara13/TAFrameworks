package decorator;

import org.openqa.selenium.WebElement;

/**
 * Interface defining actions that can be performed on web elements.
 */
public interface ElementActions {

    /** Clicks on a web element */
    void click(WebElement element);

    /** Types text into a web element */
    void type(WebElement element, String text);
}