package org.ait.demo;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
    @Test
    public void isNewsletterPresentTest(){
        Assert.assertTrue(isNewsletterPresent());
    }
}
