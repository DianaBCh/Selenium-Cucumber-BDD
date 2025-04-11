package com.project.pages;

import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginFunctionalityPage {

    public LoginFunctionalityPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "user-name")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//div[contains(@class, 'error-message-container')]/h3")
    public WebElement errorMessage;

    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }

}
