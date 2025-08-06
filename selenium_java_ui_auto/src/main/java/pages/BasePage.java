package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.Select;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    protected String getTitle() {
        return driver.getTitle();
    }

    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    protected void navigateTo(String url) {
        driver.get(url);
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    protected boolean isElementSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    protected void navigateBack() {
        driver.navigate().back();
    }

    protected void navigateForward() {
        driver.navigate().forward();
    }

    protected void refreshPage() {
        driver.navigate().refresh();
    }

    protected String getAttribute(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    protected ArrayList<WebElement> findElementsByXPath(String xpath) {
        return new ArrayList<>(driver.findElements(By.xpath(xpath)));
    }

    protected String getText(WebElement element) {
        return element.getText();
    }

    protected void selectOptionByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    protected void selectOptionByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    protected void selectOptionByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    protected void deselectOptionByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.deselectByValue(value);
    }

    protected void deselectOptionByVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        select.deselectByVisibleText(visibleText);
    }

    protected void deselectOptionByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.deselectByIndex(index);
    }

    protected boolean isMultipleSelect(WebElement element) {
        Select select = new Select(element);
        return select.isMultiple();
    }

    protected List<WebElement> getAllSelectedOptions(WebElement element) {
        Select select = new Select(element);
        return select.getAllSelectedOptions();
    }

    protected List<WebElement> getOptions(WebElement element) {
        Select select = new Select(element);
        return select.getOptions();
    }

    protected void clearField(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    protected void SelectOptionFromDropdown(WebElement dropdown, String option) {
        List<WebElement> options = getOptions(dropdown);

        if (option == null || option.isEmpty()) {
            throw new IllegalArgumentException("Option to select cannot be null or empty");
        }

        for (WebElement opt : options) {
            if (opt.getText().equalsIgnoreCase(option)) {
                opt.click();
                break;
            }
        }
    }

}
