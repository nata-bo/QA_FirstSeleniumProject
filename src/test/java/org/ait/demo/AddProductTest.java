package org.ait.demo;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddProductTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogoutButton();
        }
        app.getUser().login();
    }

    @Test
    public void addProductPositiveTest(){
       app.getProduct().clickOnProductLink();
       app.getCart().clickAddToCartButton();
       app.getCart().clickShoppingCartLink();

       WebElement cartProduct = app.getProduct().isProductPresentInCart();
       Assert.assertTrue(cartProduct.isDisplayed());
    }


}
