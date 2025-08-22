package pages;

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

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        // wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
    }

    public boolean isDashboardDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
            return isElementDisplayed(dashboardTitle);
        } catch (Exception e) {
            return false;
        }
    }

}
