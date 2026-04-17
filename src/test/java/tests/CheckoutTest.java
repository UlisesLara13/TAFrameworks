package tests;

import base.BaseTest;
import com.epam.training.student_ulises_lara.model.CheckoutData;
import com.epam.training.student_ulises_lara.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import service.TestDataReader;

/**
 * Test Case 3: Complete checkout process.
 * Verifies that a user can complete the checkout flow
 * and sees the order confirmation message.
 */
public class CheckoutTest extends BaseTest {
    @Test
    public void completeCheckout() {

        User user = new User(
                TestDataReader.getTestData("username"),
                TestDataReader.getTestData("password")
        );

        CheckoutData checkoutData = new CheckoutData(
                TestDataReader.getTestData("firstName"),
                TestDataReader.getTestData("lastName"),
                TestDataReader.getTestData("zipCode")
        );

        LoginPage loginPage = new LoginPage(driver).openPage();
        HomePage homePage = loginPage.login(user);

        homePage.addFirstProductToCart();
        homePage.goToCart();
        homePage.clickCheckout();

        homePage.enterFirstName(checkoutData.getFirstName());
        homePage.enterLastName(checkoutData.getLastName());
        homePage.enterZipCode(checkoutData.getZipCode());
        homePage.clickContinue();

        homePage.finishCheckout();

        String actual = homePage.getConfirmationMessage();
        String expected = "Thank you for your order!";

        try {
            log.info("Validating checkout");

            Assert.assertEquals(actual, expected);

            log.info("Checkout PASSED");

        } catch (AssertionError e) {
            log.error("Checkout FAILED");
            log.error("Expected: {}", expected);
            log.error("Actual: {}", actual);
            throw e;
        }
    }
}
