package tests;

import base.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Browser can be passed as parameter later
        DriverManager.initDriver("chrome");
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://example.com"); // replace with your app URL
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
