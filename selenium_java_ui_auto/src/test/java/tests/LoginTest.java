package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.DashboardPage;
import pages.LoginPage;
import pages.PasswordRecoveryPage;
import pages.PasswordRecoverySuccessPage;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest {

    ExtentTest test = ExtentReportManager.createTest("Login page tests");

    /**
     * This test verifies that a user can log in with valid credentials. TC-001
     */
    @Test(priority = 0, description = "TC-001: Login with valid credentials")
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        test.info("Navigated to Login Page");
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        test.info("Entered valid credentials: username=Admin, password=****");
        boolean dashboardDisplayed = dashboardPage.isDashboardDisplayed();
        if (dashboardDisplayed) {
            test.pass("Dashboard displayed successfully after login");
        } else {
            test.fail("Dashboard not displayed after login");
        }
        Assert.assertTrue(dashboardDisplayed, "Dashboard is not displayed after login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-002
     */
    @Test(priority = 1, description = "TC-002 : Login with invalid username")
    public void invalidUserNameValidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin1");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        test.info("Entered invalid credentials: username=Admin1, password=admin123");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-003
     */
    @Test(priority = 2, description = "TC-003 : Login with invalid password")
    public void ValidUserNameInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        test.info("Entered invalid credentials: username=Admin, password=admin12");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with invalid credentials. TC-004
     */
    @Test(priority = 3, description = "TC-004 : Login with invalid username and password")
    public void InvalidUserNameInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin1");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        test.info("Entered invalid credentials: username=Admin1, password=admin12");
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-005
     */
    @Test(priority = 4, description = "TC-005 : Login with blank username and password")
    public void LoginWithBlankField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        test.info("Clicked login button with blank username and password");
        Assert.assertTrue(loginPage.isPasswordRequiredLabelDisplayed(), "Error message is not displayed");
        Assert.assertTrue(loginPage.isUserNameRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-006
     */
    @Test(priority = 5, description = "TC-006 : Login with blank username")
    public void LoginWithBlankUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        test.info("Clicked login button with blank username");
        Assert.assertTrue(loginPage.isUserNameRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-007
     */
    @Test(priority = 6, description = "TC-007 : Login with blank password")
    public void LoginWithBlankPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        test.info("Clicked login button with blank password");
        Assert.assertTrue(loginPage.isPasswordRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies case sensitivity. TC-008
     */
    @Test(priority = 7, description = "TC-008 : Verify case sensitivity")
    public void verifyCaseSensitivity() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("admin", "admin123");
        test.info("Entered credentials with different case: username=admin, password=admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
    }

    @Test(priority = 8, description = "TC-009 : Verify password masking")
    public void verifyPasswordMasking() {
        LoginPage loginPage = new LoginPage(driver);
        String passwordFieldType = loginPage.getPasswordFieldType();
        test.info("Checked the password field type");
        Assert.assertTrue(passwordFieldType.equals("password"), "Password field is not masked");
    }

    @Test(priority = 8, description = "TC-010 : Verify Forgot Password link")
    public void forgotPasswordLinkTest() {
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(passwordRecoveryPage.isPageTitleDisplaying(), "Forgot Password page is not displayed");
        test.info("Navigated to Password Recovery Page");
        passwordRecoveryPage.enterrecoveryUsername("Admin");
        PasswordRecoverySuccessPage passwordRecoverySuccessPage = passwordRecoveryPage.clickSubmitButton();
        Assert.assertTrue(passwordRecoverySuccessPage.verifySuccessMessageIsDisplayed(),
                "Success message is not displayed");

    }

    // @Test(priority = 9, description = "TC-011 : session handling after logout.")
    public void sessionHandlingAfterLogout() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
        loginPage = dashboardPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isLoginPanelDisplayed(), "Login panel is not displayed after logout");
        driver.navigate().back();
        Assert.assertTrue(loginPage.isLoginPanelDisplayed(),
                "User should not be able to access dashboard after logout by navigating back.");
        test.info("Session is handled properly after logout");
    }

}
