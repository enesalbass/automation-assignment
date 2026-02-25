package core.driver;

import core.config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            String browser = ConfigReader.getOrDefault("browser", "chrome");
            boolean headless = ConfigReader.getBool("headless");

            if (browser.equalsIgnoreCase("chrome")) {

                WebDriverManager.chromedriver().setup();

                ChromeOptions options = new ChromeOptions();

                if (headless) {
                    options.addArguments("--headless=new");
                }

                options.addArguments("--window-size=1400,900");

                driver = new ChromeDriver(options);
            }
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}