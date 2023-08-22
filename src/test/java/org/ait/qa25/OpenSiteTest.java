package org.ait.qa25;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenSiteTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        // driver.get("https://www.google.com/"); without history
        driver.navigate().to("https://www.google.com/"); // with history
        driver.navigate().back();    // вернутся
        driver.navigate().forward(); // снова в Google
        driver.navigate().refresh(); // обновить
    }

    // tests
    @Test
    public void openGoogleTest() {
        System.out.println("Site opened!!!");
    }

    @AfterMethod
    public void  tearDown() {
        // driver.quit(); // close all tabs & browser
        driver.close(); // close only one tab (last), if tab only one - close browser
    }
    // after - tearDown
}
