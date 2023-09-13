package org.ait.demo;

import org.ait.demo.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
  @DataProvider
  public Iterator<Object[]> newUser() {
      List<Object[]> list = new ArrayList<>();
      list.add(new Object[]{"Olga", "Schmidt", "ol@gmail.com", "K887nng12$1", "K887nng12$1"});
      list.add(new Object[]{"Anna", "Brie", "bri@gmail.com", "AB887nng12$5", "AB87nng12$5"});
      list.add(new Object[]{"Nick", "Kan", "kan@gmail.com", "K887nng12$5", "K887nng12$5"});
      return list.iterator();
  }
    @DataProvider
    public Iterator<Object[]> newUserWithCSVFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/user.csv")));
        String line = reader.readLine();
        while (line !=null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .setName(split[0])
                    .setSurname(split[1])
                    .setEmail(split[2])
                    .setPassword(split[3])
                    .setConfirmPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider = "newUser")
    public void addUserPositiveTestFromDataProvider(String name,String surname,
                                                       String email,String password, String confirmPassword){
        app.getUser().fillLoginRegistrationForm(new User()
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPassword(password)
                .setConfirmPassword(confirmPassword));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isUserAdded(email));

    }
    @Test(dataProvider = "newUserWithCSVFile")
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