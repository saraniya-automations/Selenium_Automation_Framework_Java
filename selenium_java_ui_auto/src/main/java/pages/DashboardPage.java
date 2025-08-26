package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {

    // WebDriver driver;
    // WebDriverWait wait;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardTitle;
    @FindBy(className = "oxd-userdropdown-img")
    private WebElement profilePicButton;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement LogoutButton;
    @FindBy(xpath = "//button[@title='Assign Leave']")
    private WebElement assignLeaveIcon;
    @FindBy(xpath = "//button[@title='Leave List']")
    private WebElement leaveListIcon;
    @FindBy(xpath = "//button[@title='Timesheets']")
    private WebElement timesheetsIcon;
    @FindBy(xpath = "//button[@title='Apply Leave']")
    private WebElement applyLeaveIcon;
    @FindBy(xpath = "//button[@title='My Leave']")
    private WebElement myLeaveIcon;
    @FindBy(xpath = "//button[@title='My Timesheet']")
    private WebElement myTimesheetsIcon;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
            return isElementDisplayed(dashboardTitle);
        } catch (Exception e) {
            return false;
        }
    }

    public LoginPage clickLogoutButton() {
        profilePicButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(LogoutButton));
        LogoutButton.click();
        return new LoginPage(driver);
    }

    public boolean isDashboardMenuItemVisible(String menuItem) {
        By locator = By.xpath("//a//span[text()='" + menuItem + "']");
        return isElementDisplayed(locator);
    }

    public LeavePage clickAssignLeaveIcon() {
        click(assignLeaveIcon);
        return new LeavePage(driver);
    }

    public LeavePage clickLeaveListIcon() {
        click(leaveListIcon);
        return new LeavePage(driver);
    }

    public TimePage clickTimesheetsIcon() {
        click(timesheetsIcon);
        return new TimePage(driver);
    }

    public LeavePage clickApplyLeaveIcon() {
        click(applyLeaveIcon);
        return new LeavePage(driver);
    }

    public LeavePage clickMyLeaveIcon() {
        click(myLeaveIcon);
        return new LeavePage(driver);
    }

    public TimePage clickMyTimesheetIcon() {
        click(myTimesheetsIcon);
        return new TimePage(driver);
    }

}
