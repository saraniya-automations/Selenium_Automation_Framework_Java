package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    // ThreadLocal ensures driver is thread-safe for parallel runs
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void initDriver(String browser) {
        if (driver.get() == null) {
            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
            }
        }
    }

    public static WebDriver getDriver() {
        WebDriver currentDriver = driver.get();
        if (currentDriver == null) {
            throw new IllegalStateException("Driver not initialized. Call initDriver() first.");
        }
        return currentDriver;
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
