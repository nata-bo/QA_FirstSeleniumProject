package org.ait.demo;

import org.ait.demo.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogoutButton();
        }
        app.getUser().clickOnLoginLink();
    }

    @Test
    public  void loginPositiveTest(){
        app.getUser().fillLoginForm(new User()
                .setEmail("nfudj33@gmail.com")
                .setPassword("Olna123488$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLogoutButtonPresent());
   } @Test
    public  void loginNegativeWithoutEmailTest(){
        app.getUser().fillLoginForm(new User()
                .setPassword("Olna123488$"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//span[contains(., 'unsuccessful')]")));
   }

}
