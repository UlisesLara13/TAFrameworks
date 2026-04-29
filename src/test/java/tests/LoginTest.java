package tests;

import base.BaseTest;
import com.epam.training.student_ulises_lara.model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;
import service.TestDataReader;

/**
 * Test Case 1: Login user with valid credentials.
 * Verifies that the user is successfully logged in
 * and the home page is displayed.
 */
public class LoginTest extends BaseTest {

    @Test
    public void loginSuccess() {

        User user = new User(
                TestDataReader.getTestData("username"),
                TestDataReader.getTestData("password")
        );

        LoginPage loginPage = new LoginPage(driver).openPage();

        loginPage.enterUsername(user.getUsername());
        loginPage.enterPassword(user.getPassword());
        loginPage.clickLogin();

        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getHeaderTitle();
        String expectedTitle = "Swag Labs";

        log.info("Validating header title");

        Assert.assertEquals(
                actualTitle,
                expectedTitle,
                "Login failed: Header title does not match"
        );
    }
}