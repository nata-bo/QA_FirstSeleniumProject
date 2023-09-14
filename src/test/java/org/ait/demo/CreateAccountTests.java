package org.ait.demo;

import org.ait.demo.models.User;
import org.ait.demo.utils.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;


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
        app.getUser().fillLoginRegistrationForm(new User()
                       .setName("Nata")
                       .setSurname("Bo")
                       .setEmail("nfudj33@gmail.com")
                       .setPassword("Olna123488$")
                       .setConfirmPassword("Olna123488$"));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isElementPresent2(By.xpath("//li[contains(.,'The specified email already exists')]")));

    }

    @Test(dataProvider = "newUserWithCSVFile",dataProviderClass = DataProviders.class)
    public void addUserPositiveTestFromDataProviderWithCSV(User user) throws IOException, AWTException {
        app.getUser().deleteScreencast();
        app.getUser().startRecording();
        app.getUser().fillLoginRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        app.getUser().pause(1000);

        Assert.assertTrue(app.getUser().isUserAdded(user.getEmail()));
        app.getUser().stopRecording();
    }
}