package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPageSauceDemo;
import com.juaracoding.utils.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPageSauceDemo loginPageSauceDemo = new LoginPageSauceDemo();
    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }
    @Given("Admin enter url web Sauce demo")
    public void admin_enter_url_web_sauce_demo(){
        DriverSingleton.delay(2);
        driver.get(Constants.URL);
        extentTest.log(LogStatus.PASS,"Admin enter url web Sauce demo");
    }
    @When("Admin enter username and password")
    public void admin_enter_username_and_password(){
        DriverSingleton.delay(2);
        loginPageSauceDemo.login("standard_user","secret_sauce");
        extentTest.log(LogStatus.PASS,"Admin enter username and password");
    }

    @And("Admin click login button")
    public void admin_click_login_button(){
        loginPageSauceDemo.setBtnLogin();
        DriverSingleton.delay(2);
        extentTest.log(LogStatus.PASS,"Admin click login button");
    }
    @Then("Admin login successful redirect page dasboard")
    public void admin_login_successful_redirect_page_dashboard(){
        DriverSingleton.delay(2);
        Assert.assertEquals(loginPageSauceDemo.getTxtLogo(),"Swag Labs");
    }
    @Given("Admin enter url web Sauce demo or logout")
    public void admin_enter_url_web_sauce_demo_or_logout(){
        DriverSingleton.delay(2);
        loginPageSauceDemo.setMenu3Line();
        DriverSingleton.delay(2);
        loginPageSauceDemo.logout();
        extentTest.log(LogStatus.PASS,"Admin enter url web Sauce demo or logout");
    }
    @When("Admin enter null username and password")
    public void admin_enter_null_username_and_password(){
        DriverSingleton.delay(2);
        loginPageSauceDemo.login("","");
        extentTest.log(LogStatus.PASS,"Admin enter wrong username and password");
    }
    @Then("Admin required login")
    public void admin_required_login(){
        DriverSingleton.delay(2);
        Assert.assertEquals(loginPageSauceDemo.getTxtRequired(),"Epic sadface: Username is required");
        extentTest.log(LogStatus.PASS,"Admin required login");
    }
}
