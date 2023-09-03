package org.ait.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductTest extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector(".ico-login"))) {
            click(By.cssSelector(".ico-logout"));
        }
        click(By.cssSelector(".ico-login"));
        type(By.cssSelector("#Email"), "nfudj33@gmail.com");
        type(By.cssSelector("#Password"), "Olna123488$");
        click(By.cssSelector(".login-button"));
    }
   @Test
    public void addProductPositiveTest(){
        click(By.xpath("//a[contains(., 'expensive')]"));
        click(By.cssSelector("#add-to-cart-button-74"));
        click(By.cssSelector("#topcartlink"));

       WebElement cartProduct = driver.findElement(By.cssSelector(".cart-item-row"));
       Assert.assertTrue(cartProduct.isDisplayed());
    }
}
