package page;

import com.epam.training.student_ulises_lara.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.TestDataReader;

/**
 * LoginPage class represents the login page of the application.
 * It provides methods to interact with login form elements and perform login actions.
 */
public class LoginPage extends BasePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    /** URL of the login page loaded from properties */
    private final String PAGE_URL = TestDataReader.getTestData("base.url");

    /** Username input field */
    @FindBy(id = "user-name")
    private WebElement inputLogin;

    /** Password input field */
    @FindBy(id = "password")
    private WebElement inputPassword;

    /** Login button */
    @FindBy(id = "login-button")
    private WebElement buttonSubmit;

    /** Error message displayed on failed login */
    @FindBy(css = "[data-test='error']")
    private WebElement alertMessage;

    /**
     * Constructor initializes PageFactory elements.
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Opens the login page and waits until it is ready.
     *
     * @return LoginPage instance
     */
    @Override
    public LoginPage openPage() {
        log.info("Opening login page");
        driver.navigate().to(PAGE_URL);
        waitForVisibility(inputLogin);
        return this;
    }

    /**
     * Performs login using provided User credentials.
     *
     * @param user User object with username and password
     * @return HomePage after successful login
     */
    public HomePage login(User user) {
        log.info("Performing login with user: {}", user.getUsername());

        typeText(inputLogin, user.getUsername());
        typeText(inputPassword, user.getPassword());
        clickElement(buttonSubmit);

        log.info("Login submitted");

        return new HomePage(driver);
    }

    /**
     * Enters username into the input field.
     *
     * @param username username to enter
     */
    public void enterUsername(String username) {
        log.info("Entering username: {}", username);
        typeText(inputLogin, username);
    }

    /**
     * Enters password into the input field.
     *
     * @param password password to enter
     */
    public void enterPassword(String password) {
        log.info("Entering password");
        typeText(inputPassword, password);
    }

    /**
     * Clears the username field using keyboard actions.
     */
    public void clearUsername() {
        log.info("Clearing username field");
        inputLogin.sendKeys(Keys.CONTROL + "a");
        inputLogin.sendKeys(Keys.BACK_SPACE);
    }

    /**
     * Clears the password field using keyboard actions.
     */
    public void clearPassword() {
        log.info("Clearing password field");
        inputPassword.sendKeys(Keys.CONTROL + "a");
        inputPassword.sendKeys(Keys.BACK_SPACE);
    }

    /**
     * Clicks the login button.
     */
    public void clickLogin() {
        log.info("Clicking login button");
        clickElement(buttonSubmit);
    }

    /**
     * Retrieves the error message displayed after failed login.
     *
     * @return error message text
     */
    public String getAlertMessage() {
        log.info("Retrieving login error message");
        return getText(alertMessage);
    }
}