package org.ait.demo.fw;

import org.ait.demo.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public void fillLoginRegistrationForm(User user) {
        type(By.cssSelector("#FirstName"), user.getName());
        type(By.cssSelector("#LastName"), user.getSurname());
        type(By.cssSelector("#Email"), user.getEmail());
        type(By.cssSelector("#Password"), user.getPassword());
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
    }
    public void fillLoginRegistrationFormForScreencast(User user) {
        type(By.cssSelector("#FirstName"),user.getName() );
        pause(500);
        type(By.cssSelector("#LastName"), user.getSurname());
        pause(500);
        type(By.cssSelector("#Email"), user.getEmail());
        pause(500);
        type(By.cssSelector("#Password"), user.getPassword());
        pause(500);
        type(By.cssSelector("#ConfirmPassword"), user.getConfirmPassword());
        pause(1000);
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
    public void clickOnLoginButtonForScreenshot() {
        pause(1000);
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
    public boolean isUserAdded(String text){
        List<WebElement> users =  driver.findElements(By.cssSelector("div.header-links a[href='/customer/info']"));
        for (WebElement el: users){
            if(el.getText().contains(text))
                return  true;
        }
        return false;
    }
}
