package core.base;

import core.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}