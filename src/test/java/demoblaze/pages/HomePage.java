package demoblaze.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private final By homeLink = By.cssSelector("a.nav-link[href='index.html']");
    private final By cartLink = By.id("cartur");

    private By productLinkByName(String name) {
        return By.xpath("//a[@class='hrefch' and normalize-space()='" + name + "']");
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goHome() {
        click(homeLink);
    }

    public void openProduct(String productName) {
        click(productLinkByName(productName));
    }

    public void goToCart() {
        click(cartLink);
    }
}