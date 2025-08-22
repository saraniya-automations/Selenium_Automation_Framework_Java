package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    /**
     * This test verifies that a user can log in with valid credentials. TC-001
     */
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-002
     */
    @Test
    public void invalidUserNameValidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin1");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-003
     */
    @Test
    public void ValidUserNameInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-004
     */
    @Test
    public void InvalidUserNameInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin1");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    // @Test
    // public void forgotPasswordTest() {
    // LoginPage loginPage = new LoginPage(driver);
    // Assert.assertTrue(loginPage.isForgorPasswordLinkDisplayed(), "Forgot Password
    // link is not displayed");
    // }

}
