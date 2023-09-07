package org.ait.demo.fw;

import org.ait.demo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector(".ico-register"));
    }

    public void clickOnLogoutButton() {
        click(By.cssSelector(".ico-logout"));
    }

    public boolean isRegisterLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-register"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("#register-button"));
    }

    public void fillLoginRegistrationForm(String name, String surname, String email, String password) {
        type(By.cssSelector("#FirstName"), name);
        type(By.cssSelector("#LastName"), surname);
        type(By.cssSelector("#Email"),email);
        type(By.cssSelector("#Password"),password);
        type(By.cssSelector("#ConfirmPassword"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector(".ico-login"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector(".ico-login"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".login-button"));
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
    }

    public boolean isLogoutButtonPresent() {
        return isElementPresent2(By.cssSelector(".ico-logout"));
    }

    public void login() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("nfudj33@gmail.com").setPassword("Olna123488$"));
        clickOnLoginButton();
    }
}
