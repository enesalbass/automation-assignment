package saucedemo.tests;

import core.base.BaseTest;
import core.data.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests extends BaseTest {

    @Test
    @DisplayName("SauceDemo | Pozitif login -> Inventory açılmalı")
    void positiveLogin_shouldOpenInventory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.STANDARD_USER, TestUsers.PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isLoaded(), "Inventory page açılmalı (inventory_container görünmeli).");
    }
}