package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageSauceDemo {
    private WebDriver driver;

    public LoginPageSauceDemo() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user-name")
    private WebElement username;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login-button")
    private WebElement btnLogin;
    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement txtLogo;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement menu3Line;
    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalidLogin;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtRequired;
    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement txtLoginLogo;

    public void login(String username,String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }
    public void setBtnLogin(){
        btnLogin.click();
    }
    public void setMenu3Line(){
        menu3Line.click();
    }
    public void logout(){
        btnLogout.click();
    }
    public String getTxtLogo(){
    return txtLogo.getText();
    }
    public String getTxtInvalid(){
        return txtInvalidLogin.getText();
    }
    public String getTxtRequired(){
        return txtRequired.getText();
    }
    public String getTxtLoginLogo(){
        return txtLoginLogo.getText();
    }
}
