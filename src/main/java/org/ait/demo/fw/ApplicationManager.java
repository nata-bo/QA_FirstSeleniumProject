package org.ait.demo.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager{
    String browser;
    WebDriver driver;
    UserHelper user;
    CartHelper cart;
    ProductHelper product;
    HomePageHelper homePage;



    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {
      //  System.err.close();
        if(browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
         }else if (browser.equalsIgnoreCase("microsoftedge")){
            driver = new EdgeDriver();
         }else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user = new UserHelper(driver);
        cart = new CartHelper(driver);
        product = new ProductHelper(driver);
        homePage = new HomePageHelper(driver);
    }

    public void stop() {
        driver.quit();
    }


    public UserHelper getUser() {
        return user;
    }

    public CartHelper getCart() {
        return cart;
    }

    public ProductHelper getProduct() {
        return product;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }
}
