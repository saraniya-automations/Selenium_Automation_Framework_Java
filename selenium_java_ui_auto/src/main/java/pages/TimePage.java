package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TimePage extends BasePage {

    public TimePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean isTimesheetsPageDisplayed() {
        return getCurrentUrl().contains("time/viewEmployeeTimesheet");
    }

    public boolean isMyTimesheetPageDisplayed() {
        return getCurrentUrl().contains("time/viewMyTimesheet");
    }

}
