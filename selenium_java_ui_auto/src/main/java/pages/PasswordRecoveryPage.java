package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage extends BasePage {

    // Assuming there are some elements and methods specific to the Password
    // Recovery Page
    // For example, a field to enter the email address for password recovery

    @FindBy(xpath = "//h6[contains(@class,'forgot')]")
    private WebElement resetPasswordPageTitle;
    // @FindBy(css = "button[type='submit']")
    // private WebElement resetPasswordDescription;
    // @FindBy(xpath = "//div[@role='alert']//p")
    // private WebElement username;
    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameField;
    // @FindBy(xpath = "//input[@name='email']/parent::div/following-sibling::span")
    // private WebElement cancelButton;
    @FindBy(xpath = "//button[contains(@class,'button--reset')]")
    private WebElement resetPasswordButton;

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void waitForPageToLoad() {
        waitForElementToBeVisible(resetPasswordPageTitle);

    }

    public boolean isPageTitleDisplaying() {
        try {
            waitForPageToLoad();
            return isElementDisplayed(resetPasswordPageTitle);
        } catch (Exception e) {
            return false;
        }
    }

    public void enterrecoveryUsername(String string) {
        type(usernameField, string);
    }

    public PasswordRecoverySuccessPage clickSubmitButton() {
        click(resetPasswordButton);
        return new PasswordRecoverySuccessPage(driver);
    }

}
