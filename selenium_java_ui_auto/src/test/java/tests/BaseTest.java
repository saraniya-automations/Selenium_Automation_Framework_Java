package tests;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.DriverManager;
import utils.ConfigReader;

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
        driver.manage().window().maximize();
        driver.get(appUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
