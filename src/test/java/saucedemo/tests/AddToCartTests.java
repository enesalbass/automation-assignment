package saucedemo.tests;

import core.base.BaseTest;
import core.data.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.pages.CartPage;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("saucedemo")
public class AddToCartTests extends BaseTest {

    @Test
    @DisplayName("SauceDemo | Ürün sepete eklenebilmeli")
    void addProductToCart_shouldAppearInCart() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.STANDARD_USER, TestUsers.PASSWORD);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();

        assertEquals("1", inventory.getCartCount(), "Cart badge 1 olmalı.");

        inventory.goToCart();

        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.hasItem(), "Cart içinde ürün görünmeli.");
    }
}