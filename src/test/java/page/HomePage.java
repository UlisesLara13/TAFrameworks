package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import service.TestDataReader;

/**
 * HomePage represents the main page after successful login.
 * It contains actions related to products, cart, and checkout process.
 */
public class HomePage extends BasePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    /** URL of the main page loaded from properties */
    private final String PAGE_URL = TestDataReader.getTestData("base.url");

    /** Page title (Swag Labs) */
    @FindBy(className = "app_logo")
    private WebElement pageTitle;

    /** First product "Add to cart" button */
    @FindBy(css = ".inventory_item button")
    private WebElement firstAddToCartButton;

    /** Cart badge showing number of items */
    @FindBy(css = ".shopping_cart_badge")
    private WebElement cartBadge;

    /** Cart icon */
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    /** Checkout button in cart */
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    /** Checkout first name input */
    @FindBy(id = "first-name")
    private WebElement firstNameInput;

    /** Checkout last name input */
    @FindBy(id = "last-name")
    private WebElement lastNameInput;

    /** Checkout zip code input */
    @FindBy(id = "postal-code")
    private WebElement zipCodeInput;

    /** Continue button in checkout */
    @FindBy(id = "continue")
    private WebElement continueButton;

    /** Finish button in checkout overview */
    @FindBy(id = "finish")
    private WebElement finishButton;

    /** Confirmation message after order */
    @FindBy(className = "complete-header")
    private WebElement confirmationMessage;

    /**
     * Constructor initializes PageFactory elements.
     *
     * @param driver WebDriver instance
     */
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Opens the home page.
     *
     * @return HomePage instance
     */
    @Override
    public HomePage openPage() {
        log.info("Opening home page: {}", PAGE_URL);
        driver.navigate().to(PAGE_URL);
        return this;
    }

    /**
     * Gets the page title text.
     *
     * @return header title
     */
    public String getHeaderTitle() {
        log.info("Getting header title");
        return pageTitle.getText();
    }

    /**
     * Gets the confirmation message after checkout.
     *
     * @return confirmation message text
     */
    public String getConfirmationMessage() {
        log.info("Getting confirmation message");
        return getText(confirmationMessage);
    }

    /**
     * Clicks on cart icon to navigate to cart page.
     */
    public void goToCart() {
        log.info("Navigating to cart");
        clickElement(cartIcon);
    }

    /**
     * Adds the first product to the cart.
     */
    public void addFirstProductToCart() {
        log.info("Adding first product to cart");
        clickElement(firstAddToCartButton);
    }

    /**
     * Retrieves the number of items in the cart.
     *
     * @return cart item count
     */
    public int getCartCount() {
        log.info("Getting cart item count");
        return Integer.parseInt(cartBadge.getText());
    }

    /**
     * Clicks the checkout button.
     */
    public void clickCheckout() {
        log.info("Clicking checkout button");
        clickElement(checkoutButton);
    }

    /**
     * Enters first name in checkout form.
     *
     * @param firstName first name value
     */
    public void enterFirstName(String firstName) {
        log.info("Entering first name: {}", firstName);
        typeText(firstNameInput, firstName);
    }

    /**
     * Enters last name in checkout form.
     *
     * @param lastName last name value
     */
    public void enterLastName(String lastName) {
        log.info("Entering last name: {}", lastName);
        typeText(lastNameInput, lastName);
    }

    /**
     * Enters zip code in checkout form.
     *
     * @param zipCode zip code value
     */
    public void enterZipCode(String zipCode) {
        log.info("Entering zip code: {}", zipCode);
        typeText(zipCodeInput, zipCode);
    }

    /**
     * Clicks continue button in checkout step one.
     */
    public void clickContinue() {
        log.info("Clicking continue button");
        clickElement(continueButton);
    }

    /**
     * Completes the checkout process.
     */
    public void finishCheckout() {
        log.info("Finishing checkout");
        clickElement(finishButton);
    }
}