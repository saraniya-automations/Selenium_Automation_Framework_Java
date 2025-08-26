package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.DashboardPage;
import pages.LeavePage;
import pages.LoginPage;
import pages.TimePage;
import pages.BasePage;
import utils.ExtentReportManager;

public class DashboardTest extends BaseTest {

    @Test(priority = 10, description = "TC-012: Verify Dashboard menu items")
    public void verifyDashboardMenuItemsTest() {
        ExtentTest test = ExtentReportManager.createTest("TC-001: Login with valid credentials");
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Admin"), "Admin menu item is not visible");
        test.info("Admin Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("PIM"), "PIM menu item is not visible");
        test.info("PIM Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Leave"), "Leave menu item is not visible");
        test.info("Leave Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Time"), "Time menu item is not visible");
        test.info("Time Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Recruitment"),
                "Recruitment menu item is not visible");
        test.info("Recruitment Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("My Info"), "My Info menu item is not visible");
        test.info("My Info Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Performance"),
                "Performance menu item is not visible");
        test.info("Performance Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Dashboard"), "Dashboard menu item is not visible");
        test.info("Dashboard Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Directory"), "Directory menu item is not visible");
        test.info("Directory Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Maintenance"),
                "Maintenance menu item is not visible");
        test.info("Maintenance Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Claim"), "Claim menu item is not visible");
        test.info("Claim Menu item is visible");
        Assert.assertTrue(dashboardPage.isDashboardMenuItemVisible("Buzz"), "Buzz menu item is not visible");
        test.info("Buzz Menu item is visible");
    }

    @Test(priority = 11, description = "TC-013: Verify Quick launc icons navigations")
    public void verifyQuickLaunchIconsTest() {
        ExtentTest test = ExtentReportManager.createTest("TC-013: Verify Quick launc icons navigations");
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = loginPage.login("Admin", "admin123");
        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
        test.info("Dashboard displayed successfully after login");

        LeavePage leavePage = dashboardPage.clickAssignLeaveIcon();
        Assert.assertTrue(leavePage.isAssignLeavePageDisplayed(), "Did not navigate to Assign Leave page");
        test.info("Navigated to Assign Leave page successfully");
        BasePage basepage = new BasePage(driver);
        basepage.navigateBack();

        leavePage = dashboardPage.clickLeaveListIcon();
        Assert.assertTrue(leavePage.isLeaveListPageDisplayed(), "Did not navigate to Leave List page");
        test.info("Navigated to Leave List page successfully");
        basepage.navigateBack();

        TimePage TimePage = dashboardPage.clickTimesheetsIcon();
        Assert.assertTrue(TimePage.isTimesheetsPageDisplayed(), "Did not navigate to Timesheets page");
        test.info("Navigated to Timesheets page successfully");
        basepage.navigateBack();

        leavePage = dashboardPage.clickApplyLeaveIcon();
        Assert.assertTrue(leavePage.isApplyLeavePageDisplayed(), "Did not navigate to Apply Leave page");
        test.info("Navigated to Apply Leave page successfully");
        basepage.navigateBack();

        leavePage = dashboardPage.clickMyLeaveIcon();
        Assert.assertTrue(leavePage.isMyLeaveListPageDisplayed(), "Did not navigate to My Leave page");
        test.info("Navigated to My Leave page successfully");
        basepage.navigateBack();

        TimePage = dashboardPage.clickMyTimesheetIcon();
        Assert.assertTrue(TimePage.isMyTimesheetPageDisplayed(), "Did not navigate to My Timesheet page");
        test.info("Navigated to My Timesheet page successfully");
        basepage.navigateBack();
    }

    @Test(priority = 12, description = "TC-014: Verify Dashboard Widgets")
    public void verifyDashboardWidgetsTest() {

    }

}
