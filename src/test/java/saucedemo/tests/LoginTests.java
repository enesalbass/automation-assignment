package saucedemo.tests;

import core.base.BaseTest;
import core.data.TestUsers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import saucedemo.pages.InventoryPage;
import saucedemo.pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("saucedemo")
public class LoginTests extends BaseTest {

    @Test
    @DisplayName("SauceDemo | Pozitif login -> Inventory açılmalı")
    void positiveLogin_shouldOpenInventory() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.STANDARD_USER, TestUsers.PASSWORD);

        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.isLoaded(), "Inventory page açılmalı.");
    }

    @Test
    @DisplayName("SauceDemo | Negatif login -> yanlış şifre hata vermeli")
    void negativeLogin_wrongPassword_shouldShowError() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.STANDARD_USER, "wrong_password");

        assertTrue(loginPage.hasError(), "Error mesajı görünür olmalı.");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("do not match"),
                "Yanlış şifre mesajı bekleniyor.");
    }

    @Test
    @DisplayName("SauceDemo | Negatif login -> boş username hata vermeli")
    void negativeLogin_emptyUsername_shouldShowError() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", TestUsers.PASSWORD);

        assertTrue(loginPage.hasError(), "Error mesajı görünür olmalı.");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("username is required"),
                "Username required mesajı bekleniyor.");
    }

    @Test
    @DisplayName("SauceDemo | Edge case -> locked_out_user giriş yapamamalı")
    void edge_lockedOutUser_shouldBeBlocked() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(TestUsers.LOCKED_OUT_USER, TestUsers.PASSWORD);

        assertTrue(loginPage.hasError(), "Locked out durumda hata görünür olmalı.");
        assertTrue(loginPage.getErrorMessage().toLowerCase().contains("locked out"),
                "Locked out mesajı bekleniyor.");
    }
}