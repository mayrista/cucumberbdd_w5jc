package com.juaracoding.testng;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddtoCartandCoPage;
import com.juaracoding.pages.LoginPageSauceDemo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCartAndCoTestng {
    private static WebDriver driver;
    private AddtoCartandCoPage addtoCartandCoPage;
    private LoginPageSauceDemo loginPageSauceDemo;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://www.saucedemo.com";
        driver.get(url);
        loginPageSauceDemo = new LoginPageSauceDemo();
        addtoCartandCoPage= new AddtoCartandCoPage();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test(priority = 1)
    public void testLoginValid(){
        loginPageSauceDemo.login("standard_user","secret_sauce");
        loginPageSauceDemo.setBtnLogin();
        Assert.assertEquals(loginPageSauceDemo.getTxtLogo(),"Swag Labs");
        delay(2);
    }
    @Test(priority = 2)
    public void setAddtoCartandCheckout(){
        addtoCartandCoPage.setAddBackpack();
        delay(2);
        addtoCartandCoPage.setAddBikeLight();
        delay(2);
        addtoCartandCoPage.setBtnCart();
        delay(2);
        addtoCartandCoPage.setBtnCheckout();
        Assert.assertEquals(addtoCartandCoPage.getTxtCoInformation(),"Checkout: Your Information");
    }

    //testnegatif
    @Test(priority = 3)
    public void negatifDataInformation(){
        delay(2);
        addtoCartandCoPage.dataInformation("","","");
        delay(2);
        addtoCartandCoPage.setBtnContinue();
        Assert.assertEquals(addtoCartandCoPage.getTxtNegatifDataInfo(),"Error: First Name is required");
    }

    @Test(priority = 4)
    public void dataInformationCheckout() {
        delay(2);
        addtoCartandCoPage.dataInformation("Mayrista", "Fadhillah", "12321");
        delay(2);
        addtoCartandCoPage.setBtnContinue();
        Assert.assertTrue(addtoCartandCoPage.getTxtCoOverview().contains("Checkout: Overview"));
    }
     @Test(priority = 5)
     public void finishCo() {
         delay(2);
         addtoCartandCoPage.setBtnFinish();
         delay(2);
         addtoCartandCoPage.setBtnBackToHome();
         delay(2);
         Assert.assertEquals(loginPageSauceDemo.getTxtLogo(),"Swag Labs");
     }
     @Test(priority = 6)
     public void logout(){
        loginPageSauceDemo.setMenu3Line();
        delay(2);
        loginPageSauceDemo.logout();
        Assert.assertEquals(loginPageSauceDemo.getTxtLoginLogo(),"Swag Labs");
     }
    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
