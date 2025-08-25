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

    /**
     * This test verifies that a user can log in with valid credentials. TC-001
     */
    @Test(priority = 0, description = "TC-001: Login with valid credentials")
    public void loginTest() {
        ExtentTest test = ExtentReportManager.createTest("TC-001: Login with valid credentials");
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
    @Test(priority = 1, description = "TC-002")
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
    @Test(priority = 2, description = "TC-003")
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
    @Test(priority = 3, description = "TC-004")
    public void InvalidUserNameInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin1");
        loginPage.enterPassword("admin12");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-005
     */
    @Test(priority = 4, description = "TC-005")
    public void LoginWithBlankField() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isPasswordRequiredLabelDisplayed(), "Error message is not displayed");
        Assert.assertTrue(loginPage.isUserNameRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-006
     */
    @Test(priority = 5, description = "TC-006")
    public void LoginWithBlankUserName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isUserNameRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies that a user cannot log in with empty credentials. TC-007
     */
    @Test(priority = 6, description = "TC-007")
    public void LoginWithBlankPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isPasswordRequiredLabelDisplayed(), "Error message is not displayed");
    }

    /**
     * This test verifies case sensitivity. TC-008
     */
    @Test(priority = 7, description = "TC-008")
    public void verifyCaseSensitivity() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
    }

    @Test(priority = 8, description = "TC-009")
    public void verifyPasswordMasking() {
        LoginPage loginPage = new LoginPage(driver);
        String passwordFieldType = loginPage.getPasswordFieldType();
        Assert.assertTrue(passwordFieldType.equals("password"), "Password field is not masked");
    }

    @Test(priority = 8, description = "TC-010")
    public void forgotPasswordLinkTest() {
        LoginPage loginPage = new LoginPage(driver);
        PasswordRecoveryPage passwordRecoveryPage = loginPage.clickForgotPasswordLink();
        Assert.assertTrue(passwordRecoveryPage.isPageTitleDisplaying(), "Forgot Password page is not displayed");
        passwordRecoveryPage.enterrecoveryUsername("Admin");
        PasswordRecoverySuccessPage passwordRecoverySuccessPage = passwordRecoveryPage.clickSubmitButton();
        Assert.assertTrue(passwordRecoverySuccessPage.verifySuccessMessageIsDisplayed(),
                "Success message is not displayed");

    }

}
