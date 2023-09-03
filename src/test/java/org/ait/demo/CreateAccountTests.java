package org.ait.demo;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector(".ico-register"))) {
            click(By.cssSelector(".ico-logout"));
        }
        click(By.cssSelector(".ico-register"));
    }

    @Test
    public void exictedUserRegistrationNegativeTest() {
        type(By.cssSelector("#FirstName"), "Nata");
        type(By.cssSelector("#LastName"), "Bo");
        type(By.cssSelector("#Email"), "nfudj33@gmail.com");
        type(By.cssSelector("#Password"), "Olna123488$");
        type(By.cssSelector("#ConfirmPassword"), "Olna123488$");

        click(By.cssSelector("#register-button"));

        Assert.assertTrue(isElementPresent2(By.xpath("//li[contains(.,'The specified email already exists')]")));

    }


}