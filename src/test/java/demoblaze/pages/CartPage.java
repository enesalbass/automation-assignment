package demoblaze.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartTable = By.id("tbodyid");
    private final By placeOrderBtn = By.xpath("//button[normalize-space()='Place Order']");

    private By rowByProductName(String productName) {
        return By.xpath("//tr[td[normalize-space()='" + productName + "']]");
    }

    private By deleteLinkByProductName(String productName) {
        return By.xpath("//tr[td[normalize-space()='" + productName + "']]//a[normalize-space()='Delete']");
    }

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasProduct(String productName) {
        return isVisible(cartTable) && isVisible(rowByProductName(productName));
    }

    public void deleteProduct(String productName) {
        click(deleteLinkByProductName(productName));
    }

    public void clickPlaceOrder() {
        click(placeOrderBtn);
    }
}