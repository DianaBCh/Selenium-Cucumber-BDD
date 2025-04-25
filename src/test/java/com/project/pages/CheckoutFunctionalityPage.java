package com.project.pages;

import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFunctionalityPage {

    public CheckoutFunctionalityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@data-test='shopping-cart-link']")
    public WebElement cartButton;

    @FindBy(xpath = "//button[@data-test='checkout']")
    public WebElement checkoutButton;

    @FindBy(id = "first-name")
    public WebElement firstNameInput;

    @FindBy(id = "last-name")
    public WebElement lastNameInput;

    @FindBy(id = "postal-code")
    public WebElement postalCodeInput;

    @FindBy(id = "continue")
    public WebElement continueButton;

    @FindBy(id = "cancel")
    public WebElement cancelButton;

    @FindBy(id = "finish")
    public WebElement finishButton;

    @FindBy(id = "back-to-products")
    public WebElement backHomeButton;

    @FindBy(css = "h2.complete-header")
    public WebElement thankYouMessage;

    @FindBy(css = "h3[data-test='error']")
    public WebElement errorMessage;

    public void fillCheckoutForm(String firstName, String lastName, String postalCode) {
        firstNameInput.sendKeys(firstName);
        lastNameInput.sendKeys(lastName);
        postalCodeInput.sendKeys(postalCode);
    }


}
