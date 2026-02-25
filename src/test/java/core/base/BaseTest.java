package core.base;

import core.config.ConfigReader;
import core.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        ConfigReader.init();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}