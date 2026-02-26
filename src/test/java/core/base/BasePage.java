package core.base;

import core.config.ConfigReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    protected final WebDriver driver;
    protected final WebDriverWait wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        ConfigReader.init();
        int timeout = Integer.parseInt(ConfigReader.getOrDefault("timeoutSec", "10"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    protected WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        clickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement el = visible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected String text(By locator) {
        return visible(locator).getText().trim();
    }

    protected boolean isVisible(By locator) {
        try {
            return visible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected void jsClick(By locator) {
        WebElement el = clickable(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
    }

    protected boolean isPresent(By locator) {
        try {
            List<WebElement> els = driver.findElements(locator);
            return !els.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    protected void waitUntilNotVisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void acceptAlertIfPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
        } catch (TimeoutException ignored) {
        }
    }

}