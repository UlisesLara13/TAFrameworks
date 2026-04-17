package tests;

import base.BaseTest;
import com.epam.training.student_ulises_lara.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import service.TestDataReader;

/**
 * Test Case 2: Add product to cart.
 * Verifies that a product can be added to the cart
 * and the cart badge updates correctly.
 */
public class CartTest extends BaseTest {

    @Test
    public void addProductToCart() {

        User user = new User(
                TestDataReader.getTestData("username"),
                TestDataReader.getTestData("password")
        );

        LoginPage loginPage = new LoginPage(driver).openPage();
        HomePage homePage = loginPage.login(user);

        homePage.addFirstProductToCart();

        int actual = homePage.getCartCount();
        int expected = 1;

        try {
            log.info("Validating cart count");

            Assert.assertEquals(actual, expected);

            log.info("Cart validation PASSED");

        } catch (AssertionError e) {
            log.error("Cart validation FAILED");
            log.error("Expected: {}", expected);
            log.error("Actual: {}", actual);
            throw e;
        }
    }
}
