package org.ait.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isRegisterLinkPresent()) {
            app.getUser().clickOnLogoutButton();
        }
        app.getUser().clickOnRegisterLink();
    }

    @Test
    public void exictedUserRegistrationNegativeTest() {
        app.getUser().fillLoginRegistrationForm("Nata", "Bo", "nfudj33@gmail.com", "Olna123488$");
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//li[contains(.,'The specified email already exists')]")));

    }


}