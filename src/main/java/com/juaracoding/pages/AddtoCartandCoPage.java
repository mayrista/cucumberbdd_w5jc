package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCartandCoPage {
    private WebDriver driver;

    public AddtoCartandCoPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement addBackpack;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addBikeLight;
    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement btnCheckout;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtCheckoutInformation;
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postalCode;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtNegatifDataInfo;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;
    @FindBy(xpath = "//div[@class='header_secondary_container']")
    private WebElement txtcheckoutOverview;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;
    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtFinish;
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackToHome;

    public void setAddBackpack() {
        addBackpack.click();
    }

    public void setAddBikeLight() {
        addBikeLight.click();
    }

    public void setBtnCart() {
        btnCart.click();
    }

    public void setBtnCheckout() {
        btnCheckout.click();
    }

    public void dataInformation(String firstName, String lastName, String postalCode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }

    public void setBtnContinue() {
        btnContinue.click();
    }

    public void setBtnFinish() {
        btnFinish.click();
    }
    public void setBtnBackToHome(){
        btnBackToHome.click();
    }

    public String getTxtCoInformation() {
        return txtCheckoutInformation.getText();
    }

    public String getTxtCoOverview() {
        return txtcheckoutOverview.getText();
    }
    public String getTxtNegatifDataInfo(){
        return txtNegatifDataInfo.getText();
    }
    public String getTxtFinish(){
        return txtFinish.getText();
    }
}
