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
    @FindBy(xpath = "//input[@name='username']/parent::div/following-sibling::span")
    private WebElement usernameRequiredLabel;
    @FindBy(xpath = "//input[@name='password']/parent::div/following-sibling::span")
    private WebElement passwordRequiredLabel;
    @FindBy(xpath = "//div[contains(@class,'forgot')]/p")
    private WebElement forgotPasswordLink;

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

    public boolean isPasswordRequiredLabelDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordRequiredLabel));
            return isElementDisplayed(passwordRequiredLabel);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isUserNameRequiredLabelDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(usernameRequiredLabel));
            return isElementDisplayed(usernameRequiredLabel);
        } catch (Exception e) {
            return false;
        }
    }

    public String getPasswordFieldType() {
        try {
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            return passwordField.getAttribute("type");
        } catch (Exception e) {
            return null;
        }
    }

    public PasswordRecoveryPage clickForgotPasswordLink() {
        forgotPasswordLink.click();
        PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage(driver);
        passwordRecoveryPage.waitForPageToLoad();
        return passwordRecoveryPage;
    }

    public boolean isLoginPanelDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(loginButton));
            return isElementDisplayed(loginButton);
        } catch (Exception e) {
            return false;
        }
    }

}
