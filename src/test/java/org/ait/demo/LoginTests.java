package org.ait.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector(".ico-login"))) {
            click(By.cssSelector(".ico-logout"));
        }
        click(By.cssSelector(".ico-login"));
    }
   @Test
    public  void loginPositiveTest(){
       type(By.cssSelector("#Email"), "nfudj33@gmail.com");
       type(By.cssSelector("#Password"), "Olna123488$");

       click(By.cssSelector(".login-button"));
       Assert.assertTrue(isElementPresent2(By.cssSelector(".ico-logout")));
   }

}
