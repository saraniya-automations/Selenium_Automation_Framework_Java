package tests;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverManager;
import utils.ConfigReader;
import utils.ExtentReportManager;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        String browser = ConfigReader.getBrowser();
        String appUrl = ConfigReader.getAppUrl();
        System.out.println("Browser from config: " + browser);
        System.out.println("URL from config: " + appUrl);

        DriverManager.initDriver(browser);
        driver = DriverManager.getDriver();
        System.out.println("Driver initialized: " + (driver != null));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // maximize only if NOT running inside GitHub Actions
        if (System.getenv("GITHUB_ACTIONS") == null) {
            driver.manage().window().maximize();
        }

        driver.get(appUrl);

    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
        ExtentReportManager.getInstance().flush();
    }

}
