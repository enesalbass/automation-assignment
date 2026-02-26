package demoblaze.pages;

import core.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    private final By addToCartBtn = By.xpath("//a[contains(@class,'btn') and contains(normalize-space(),'Add to cart')]");
    private final By productTitle = By.cssSelector("h2.name");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return text(productTitle);
    }

    public void addToCartAndAcceptAlert() {
        click(addToCartBtn);
        acceptAlertIfPresent();
    }
}