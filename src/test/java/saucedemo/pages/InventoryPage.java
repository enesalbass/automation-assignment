package saucedemo.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    private final By inventoryContainer = By.id("inventory_container");
    private final By firstAddToCartBtn = By.cssSelector(".inventory_item button");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By cartIcon = By.className("shopping_cart_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return isVisible(inventoryContainer);
    }

    public void addFirstProductToCart() {
        click(firstAddToCartBtn);
    }

    public String getCartCount() {
        return text(cartBadge);
    }

    public void goToCart() {
        click(cartIcon);
    }
}