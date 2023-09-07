package org.ait.demo.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends HelperBase {
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public  boolean isNewsletterPresent(){
        return driver.findElements(By.xpath("//strong[contains(.,'Newsletter')]")).size()>0;
    }
}
