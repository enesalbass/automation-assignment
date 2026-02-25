// src/test/java/core/base/BaseTest.java
package core.base;

import core.config.ConfigReader;
import core.driver.DriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        ConfigReader.init();
        driver = DriverFactory.getDriver();
        assertNotNull(driver, "DriverFactory.getDriver() null döndü (driver oluşturulamadı).");

        driver.manage().deleteAllCookies();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterEach
    void tearDown() {
        DriverFactory.quitDriver();
    }
}