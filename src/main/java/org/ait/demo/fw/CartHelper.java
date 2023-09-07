package org.ait.demo.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends HelperBase{
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCartLink() {
        click(By.cssSelector("#topcartlink"));
    }

    public void clickAddToCartButton() {
        click(By.cssSelector("#add-to-cart-button-74"));
    }
}
