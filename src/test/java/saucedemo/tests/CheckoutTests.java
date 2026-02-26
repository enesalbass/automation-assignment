package saucedemo.tests;

import core.base.BaseTest;
import core.data.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.pages.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("saucedemo")
public class CheckoutTests extends BaseTest {

    @Test
    @DisplayName("SauceDemo | Checkout flow -> Sipariş tamamlanmalı")
    void checkoutFlow_shouldCompleteOrder() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.STANDARD_USER, TestUsers.PASSWORD);

        InventoryPage inventory = new InventoryPage(driver);
        inventory.addFirstProductToCart();
        inventory.goToCart();

        CartPage cart = new CartPage(driver);
        assertTrue(cart.hasItem(), "Checkout öncesi cart içinde ürün olmalı.");
        cart.clickCheckout();

        CheckoutInfoPage info = new CheckoutInfoPage(driver);
        info.fillForm("Enes", "Albas", "34000");
        info.clickContinue();

        CheckoutOverviewPage overview = new CheckoutOverviewPage(driver);
        overview.clickFinish();

        CheckoutCompletePage complete = new CheckoutCompletePage(driver);
        assertTrue(complete.isComplete(), "Checkout complete header görünmeli.");
    }
}