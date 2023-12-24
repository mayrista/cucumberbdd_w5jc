package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddtoCartandCoPage;
import com.juaracoding.pages.LoginPageSauceDemo;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddtoCartAndCoTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPageSauceDemo loginPageSauceDemo = new LoginPageSauceDemo();
    private static AddtoCartandCoPage addtoCartandCoPage = new AddtoCartandCoPage();
    public AddtoCartAndCoTest(){
        driver = Hooks.driver;
        extentTest= Hooks.extentTest;

    }
    @Given("Admin Login web Sauce Demo")
    public void admin_login_web_sauce_demo(){
        loginPageSauceDemo.login("standard_user","secret_sauce");
        DriverSingleton.delay(2);
        loginPageSauceDemo.setBtnLogin();
        extentTest.log(LogStatus.PASS,"Admin Login web Sauce Demo");
    }
    @When("Admin click button add to cart from item")
    public void admin_click_button_add_to_cart_from_item(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setAddBackpack();
        DriverSingleton.delay(2);
        addtoCartandCoPage.setAddBikeLight();
        extentTest.log(LogStatus.PASS,"Admin click button add to cart from item");
    }
    @And("Admin click button cart")
    public void admin_click_button_cart(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setBtnCart();
        extentTest.log(LogStatus.PASS,"Admin click button cart");
    }

    @Given("Admin click button checkout")
    public void admin_click_button_checkout(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setBtnCheckout();
        extentTest.log(LogStatus.PASS,"Admin click button checkout");
    }
    @And("Admin enter null first and lastname and postalcode")
    public void admin_enter_null_first_and_lastname_and_postalcode(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.dataInformation("","","");
        extentTest.log(LogStatus.PASS,"Admin enter null first and lastname and postalcode");
    }
    @And("Admin click button Continue")
    public void admin_click_button_continue(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setBtnContinue();
        extentTest.log(LogStatus.PASS,"Admin click button Continue");
    }
    @Then("Admin error required")
    public void admin_error_required(){
        DriverSingleton.delay(2);
        Assert.assertEquals(addtoCartandCoPage.getTxtNegatifDataInfo(),"Error: First Name is required");
        extentTest.log(LogStatus.PASS,"Admin error required");
    }
    @And("Admin enter first and lastname and postalcode")
    public void admin_enter_first_and_lastname_and_postalcode(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.dataInformation("Mayrista","Fadhillah","12321");
        extentTest.log(LogStatus.PASS,"Admin enter first and lastname and postalcode");
    }
    @And("Admin click button finish")
    public void admin_click_button_finish(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setBtnFinish();
        extentTest.log(LogStatus.PASS,"Admin click button finish");
    }
    @And("Admin click back home")
    public void admin_click_back_home(){
        DriverSingleton.delay(2);
        addtoCartandCoPage.setBtnBackToHome();
        extentTest.log(LogStatus.PASS,"Admin click back home");
    }
    @Then("Admin successful checkout redirect page dashboard")
    public void admin_successful_checkout_redirect_page_dashboard(){
        Assert.assertEquals(loginPageSauceDemo.getTxtLogo(),"Swag Labs");
        extentTest.log(LogStatus.PASS,"Admin successful checkout redirect page dashboard");
    }
    @And("Admin Logout")
    public void admin_logout(){
        DriverSingleton.delay(2);
        loginPageSauceDemo.setMenu3Line();
        loginPageSauceDemo.logout();
    extentTest.log(LogStatus.PASS,"Admin Logout");
    }

}
