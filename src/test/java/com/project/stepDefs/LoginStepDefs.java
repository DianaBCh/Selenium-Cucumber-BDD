package com.project.stepDefs;

import com.project.pages.LoginFunctionalityPage;
import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.module.Configuration;

public class LoginStepDefs {

    LoginFunctionalityPage loginFunctionalityPage = new LoginFunctionalityPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("swagLabs"));
    }

    @Then("I should see the username field")
    public void i_should_see_the_username_field() {

        loginFunctionalityPage.username.isDisplayed();

    }

    @Then("I should see the password field")
    public void i_should_see_the_password_field() {

        loginFunctionalityPage.password.isDisplayed();

    }

    @When("I enter valid username {string} and valid password {string}")
    public void iEnterValidUsernameAndValidPassword(String username, String password) {

        loginFunctionalityPage.username.sendKeys(username);
        loginFunctionalityPage.password.sendKeys(password);

    }


    @When("I click on the login button")
    public void i_click_on_the_login_button() {

        loginFunctionalityPage.loginButton.click();

    }
    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {

        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("User is NOT on the dashboard page!", expectedURL, actualURL);

    }

    @When("I enter invalid username {string} and invalid password {string}")
    public void iEnterInvalidUsernameAndInvalidPassword(String username, String password) {

        loginFunctionalityPage.username.sendKeys(username);
        loginFunctionalityPage.password.sendKeys(password);
    }

    @Then("I should see {string} error message")
    public void i_should_see_error_message(String expectedMessage) {

        String actualMessage = loginFunctionalityPage.errorMessage.getText();
        Assert.assertEquals("Error message does not match!", expectedMessage,actualMessage);

    }

    @When("I leave the username field empty")
    public void i_leave_the_username_field_empty() {

        loginFunctionalityPage.username.clear();

    }

    @And("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {

        loginFunctionalityPage.password.sendKeys(password);

    }

    @When("I enter a valid username {string}")
    public void iEnterAValidUsername(String username) {

        loginFunctionalityPage.username.sendKeys(username);
    }


    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {

        loginFunctionalityPage.password.clear();

    }

    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {

        loginFunctionalityPage.username.clear();
        loginFunctionalityPage.password.clear();



    }





}
