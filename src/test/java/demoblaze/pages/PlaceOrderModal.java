package demoblaze.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaceOrderModal extends BasePage {

    private final By modal = By.id("orderModal");

    private final By name = By.id("name");
    private final By country = By.id("country");
    private final By city = By.id("city");
    private final By card = By.id("card");
    private final By month = By.id("month");
    private final By year = By.id("year");

    private final By purchaseBtn = By.xpath("//button[normalize-space()='Purchase']");
    private final By closeBtn = By.xpath("//div[@id='orderModal']//button[normalize-space()='Close']");
    private final By sweetAlert = By.cssSelector(".sweet-alert");
    private final By sweetAlertOk = By.xpath("//button[normalize-space()='OK']");

    public PlaceOrderModal(WebDriver driver) {
        super(driver);
    }

    public boolean isOpen() {
        return isVisible(modal);
    }

    public void fill(String n, String ctry, String cty, String cc, String m, String y) {
        type(name, n);
        type(country, ctry);
        type(city, cty);
        type(card, cc);
        type(month, m);
        type(year, y);
    }

    public void purchase() {
        click(purchaseBtn);
    }

    public boolean isPurchaseSuccessVisible() {
        return isVisible(sweetAlert);
    }

    public void confirmSuccess() {
        click(sweetAlertOk);
    }

    public void close() {
        click(closeBtn);
    }
}