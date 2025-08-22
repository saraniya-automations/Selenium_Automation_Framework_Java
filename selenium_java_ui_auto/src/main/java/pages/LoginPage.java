package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    // WebDriver driver;
    // WebDriverWait wait;

    @FindBy(css = "input[name='username']")
    private WebElement usernameField;
    @FindBy(css = "input[name='password']")
    private WebElement passwordField;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//div[@role='alert']//p")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        type(usernameField, username);
    }

    public void enterPassword(String password) {
        type(passwordField, password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public DashboardPage login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardPage(driver);
    }

    public boolean isErrorMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return isElementDisplayed(errorMessage);
        } catch (Exception e) {
            return false;
        }
    }

}
