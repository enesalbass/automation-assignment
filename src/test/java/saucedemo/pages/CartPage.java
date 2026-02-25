package saucedemo.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartItem = By.className("cart_item");
    private final By checkoutBtn = By.id("checkout");


    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasItem() {
        return isVisible(cartItem);
    }

    public void clickCheckout() {
        click(checkoutBtn);
    }
}