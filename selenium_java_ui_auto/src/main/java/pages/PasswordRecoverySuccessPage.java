package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoverySuccessPage extends BasePage {

    @FindBy(xpath = "//p[text()='A reset password link has been sent to you via email.']")
    private WebElement successMessage;

    public PasswordRecoverySuccessPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean verifySuccessMessageIsDisplayed() {
        return successMessage.isDisplayed();
    }

}
