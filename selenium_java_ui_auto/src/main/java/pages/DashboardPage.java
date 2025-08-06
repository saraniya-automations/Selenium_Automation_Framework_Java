package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardTitle;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean isDashboardDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(dashboardTitle));
        return dashboardTitle.isDisplayed();
    }

}
