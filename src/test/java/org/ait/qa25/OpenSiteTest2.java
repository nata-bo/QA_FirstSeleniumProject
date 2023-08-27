package org.ait.qa25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class OpenSiteTest2 {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.navigate().to("https://demowebshop.tricentis.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void findElementByCssTest(){
        driver.findElement(By.cssSelector("form"));
        driver.findElement(By.cssSelector("#bar-notification"));
        driver.findElement(By.cssSelector("#dialog-notifications-error"));
        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        driver.findElement(By.cssSelector("#ui-id-1"));
        driver.findElement(By.cssSelector(".count"));
        driver.findElement(By.cssSelector(".tags"));
        driver.findElement(By.cssSelector(".poll"));
        driver.findElement(By.cssSelector(".page-body"));
        driver.findElement(By.cssSelector("[title='Close']"));
        driver.findElement(By.cssSelector("[name$='Email']"));

    }
    @Test
    public void findElementByXpathTest(){
        driver.findElement(By.xpath("//form"));
        driver.findElement(By.xpath("//div[@id='bar-notification']"));
        driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));
        driver.findElement(By.xpath("//div[@id='dialog-notifications-success']"));
        driver.findElement(By.xpath("//ul[@id='ui-id-1']"));
        driver.findElement(By.xpath("//div[@class='count']"));
        driver.findElement(By.xpath("//div[@class='tags']"));
        driver.findElement(By.xpath("//div[@class='poll']"));
        driver.findElement(By.xpath("//div[@class='page-body']"));
        driver.findElement(By.xpath("//span[@title='Close']"));
        driver.findElement(By.xpath("//span[contains(., 'newsletter')]"));

    }
    @Test
    public void openDemoWebShopTest(){
        System.out.println("Site opened!!!");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

