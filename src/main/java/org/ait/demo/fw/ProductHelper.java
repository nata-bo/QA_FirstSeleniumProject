package org.ait.demo.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductHelper extends HelperBase{
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductLink() {
        click(By.xpath("//h2[@class='product-title']/a[contains(., 'expensive')]"));
    }
    public WebElement isProductPresentInCart() {
        WebElement product = driver.findElement(By.cssSelector(".cart-item-row"));
        return product;
    }
}
