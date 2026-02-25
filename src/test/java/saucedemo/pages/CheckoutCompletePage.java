package saucedemo.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private final By completeHeader = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isComplete() {
        return isVisible(completeHeader);
    }

    public String getHeaderText() {
        return text(completeHeader);
    }
}