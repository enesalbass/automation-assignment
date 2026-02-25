package core.driver;

import core.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public final class DriverFactory {

    private static WebDriver driver;

    private DriverFactory() {}

    public static WebDriver getDriver() {

        if (driver != null) return driver;

        ConfigReader.init();

        String browser = ConfigReader.getOrDefault("browser", "chrome").trim().toLowerCase();
        boolean headless = ConfigReader.getBool("headless");

        if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            EdgeOptions options = new EdgeOptions();
            if (headless) options.addArguments("--headless=new");
            options.addArguments("--window-size=1400,900");
            driver = new EdgeDriver(options);
            return driver;
        }

        // default: chrome
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (headless) options.addArguments("--headless=new");
        options.addArguments("--window-size=1400,900");
        driver = new ChromeDriver(options);
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                driver = null;
            }
        }
    }
}