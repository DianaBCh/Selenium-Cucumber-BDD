package com.project.stepDefs;

import com.project.pages.LoginFunctionalityPage;
import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.lang.module.Configuration;

public class LoginStepDefs {

    LoginFunctionalityPage loginFunctionalityPage = new LoginFunctionalityPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("swagLabs"));
    }

    @Then("I should see the username field")
    public void i_should_see_the_username_field() {


    }

    @Then("I should see the password field")
    public void i_should_see_the_password_field() {

    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password() {

    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {

    }
    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {

    }

    @When("I enter invalid username and password")
    public void i_enter_invalid_username_and_password() {

    }

    @Then("I should see {string} error message")
    public void i_should_see_error_message(String string) {

    }

    @When("I leave the username field empty")
    public void i_leave_the_username_field_empty() {

    }
    @When("I enter a valid password")
    public void i_enter_a_valid_password() {

    }

    @When("I enter a valid username")
    public void i_enter_a_valid_username() {

    }
    @When("I leave the password field empty")
    public void i_leave_the_password_field_empty() {

    }


    @When("I leave the username and password fields empty")
    public void i_leave_the_username_and_password_fields_empty() {

    }
    @Then("I should see the error message {string}")
    public void i_should_see_the_error_message(String string) {

    }


}
