package com.juaracoding.testng;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPageSauceDemo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginSauceDemoTestng {
    private static WebDriver driver;
    private LoginPageSauceDemo loginPageSauceDemo;

    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        String url = "https://www.saucedemo.com";
        driver.get(url);
        loginPageSauceDemo = new LoginPageSauceDemo();
    }
    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test(priority = 1)
    public void testLoginValid(){
        loginPageSauceDemo.login("standard_user","secret_sauce");
        delay(2);
        loginPageSauceDemo.setBtnLogin();
        Assert.assertEquals(loginPageSauceDemo.getTxtLogo(),"Swag Labs");
        delay(2);
    }
    @Test(priority = 2)
    public void loginUsernamePassNull(){
        loginPageSauceDemo.setMenu3Line();
        delay(2);
        loginPageSauceDemo.logout();
        delay(2);
        loginPageSauceDemo.login("","");
        loginPageSauceDemo.setBtnLogin();
        delay(2);
        Assert.assertEquals(loginPageSauceDemo.getTxtRequired(),"Epic sadface: Username is required");
    }
    @Test(priority = 3)
    public void testLoginInvalid(){
        loginPageSauceDemo.login("user","secret_sauce");
        delay(2);
        loginPageSauceDemo.setBtnLogin();
        Assert.assertEquals(loginPageSauceDemo.getTxtInvalid(),"Epic sadface: Username and password do not match any user in this service");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
