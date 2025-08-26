package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LeavePage extends BasePage {

    public LeavePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isApplyLeavePageDisplayed() {
        return getCurrentUrl().contains("leave/applyLeave");
    }

    public boolean isLeaveListPageDisplayed() {
        return getCurrentUrl().contains("leave/viewLeaveList");
    }

    public boolean isMyLeaveListPageDisplayed() {
        return getCurrentUrl().contains("leave/viewMyLeaveList");
    }

    public boolean isAssignLeavePageDisplayed() {
        return getCurrentUrl().contains("leave/assignLeave");
    }

}
