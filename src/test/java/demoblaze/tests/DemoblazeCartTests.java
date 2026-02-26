package demoblaze.tests;

import core.base.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import demoblaze.pages.CartPage;
import demoblaze.pages.HomePage;
import demoblaze.pages.PlaceOrderModal;
import demoblaze.pages.ProductPage;

import static org.junit.jupiter.api.Assertions.*;

@Tag("demoblaze")
public class DemoblazeCartTests extends BaseTest {

    private final String PRODUCT = "Samsung galaxy s6";

    @Test
    @DisplayName("Demoblaze | Add to cart -> ürün cart'ta görünmeli")
    void addToCart_shouldAppearInCart() {

        HomePage home = new HomePage(driver);
        home.openProduct(PRODUCT);

        ProductPage product = new ProductPage(driver);
        assertTrue(product.getTitle().toLowerCase().contains("samsung"), "Ürün detay sayfası açılmış olmalı.");
        product.addToCartAndAcceptAlert();

        home.goToCart();

        CartPage cart = new CartPage(driver);
        assertTrue(cart.hasProduct(PRODUCT), "Cart içinde ürün görünmeli.");
    }

    @Test
    @DisplayName("Demoblaze | Remove from cart -> ürün silinebilmeli")
    void removeFromCart_shouldRemoveItem() {

        HomePage home = new HomePage(driver);
        home.openProduct(PRODUCT);

        ProductPage product = new ProductPage(driver);
        product.addToCartAndAcceptAlert();

        home.goToCart();

        CartPage cart = new CartPage(driver);
        assertTrue(cart.hasProduct(PRODUCT), "Silmeden önce ürün cart'ta olmalı.");

        cart.deleteProduct(PRODUCT);

        assertFalse(cart.hasProduct(PRODUCT), "Silme sonrası ürün cart'ta görünmemeli.");
    }

    @Test
    @DisplayName("Demoblaze | Purchase -> sipariş tamamlanmalı")
    void purchase_shouldCompleteOrder() {

        HomePage home = new HomePage(driver);
        home.openProduct(PRODUCT);

        ProductPage product = new ProductPage(driver);
        product.addToCartAndAcceptAlert();

        home.goToCart();

        CartPage cart = new CartPage(driver);
        assertTrue(cart.hasProduct(PRODUCT), "Purchase öncesi cart içinde ürün olmalı.");
        cart.clickPlaceOrder();

        PlaceOrderModal modal = new PlaceOrderModal(driver);
        assertTrue(modal.isOpen(), "Place Order modal açılmalı.");

        modal.fill("Enes", "Turkey", "Istanbul", "4111111111111111", "12", "2028");
        modal.purchase();

        assertTrue(modal.isPurchaseSuccessVisible(), "Purchase sonrası başarı popup'ı görünmeli.");
        modal.confirmSuccess();
    }
}