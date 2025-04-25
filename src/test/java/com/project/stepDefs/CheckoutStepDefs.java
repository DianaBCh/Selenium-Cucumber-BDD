package com.project.stepDefs;

import com.project.pages.CheckoutFunctionalityPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class CheckoutStepDefs {

    CheckoutFunctionalityPage checkoutFunctionalityPage = new CheckoutFunctionalityPage();

    @When("The user navigates to the checkout page")
    public void the_user_navigates_to_the_checkout_page() {

        checkoutFunctionalityPage.cartButton.click();
        BrowserUtils.sleep(3);
        checkoutFunctionalityPage.checkoutButton.click();

    }

    @When("The user fills in First Name as {string}, Last Name as {string}, and Postal Code as {string}")
    public void the_user_fills_in_first_name_as_last_name_as_and_zip_postal_code_as(String firstName, String lastName, String postalCode) {

        checkoutFunctionalityPage.fillCheckoutForm(firstName,lastName,postalCode);

    }

    @When("The user clicks the Continue button")
    public void the_user_clicks_the_continue_button() {

        checkoutFunctionalityPage.continueButton.click();

    }

    @Then("The user should be redirected to the Overview page")
    public void theUserShouldBeRedirectedToTheOverviewPage() {

        String actualTitle = Driver.getDriver().findElement(By.className("title")).getText();
        Assert.assertEquals("Checkout: Overview", actualTitle);//Checkout: Overview

    }

    @And("The Finish button should be displayed")
    public void theFinishButtonShouldBeDisplayed() {

        Assert.assertTrue(checkoutFunctionalityPage.finishButton.isDisplayed());
    }

    @When("The user clicks the Finish button")
    public void the_user_clicks_the_finish_button() {

    }

    @Then("The user should see a confirmation message {string}")
    public void the_user_should_see_a_confirmation_message(String string) {

    }


    @When("The user leaves all fields empty")
    public void the_user_leaves_all_fields_empty() {

    }


    @Then("An error message should be displayed: {string}")
    public void an_error_message_should_be_displayed(String string) {

    }


    @When("The user fills First Name as {string} and Last Name as {string}")
    public void the_user_fills_first_name_as_and_last_name_as(String string, String string2) {

    }

    @When("Leaves Postal Code field empty")
    public void leaves_postal_code_field_empty() {

    }


    @When("The user fills Last Name as {string} and Postal Code as {string}")
    public void the_user_fills_last_name_as_and_zip_postal_code_as(String string, String string2) {

    }
    @When("Leaves First Name field empty")
    public void leaves_first_name_field_empty() {

    }


    @When("The user fills First Name as {string} and Postal Code as {string}")
    public void the_user_fills_first_name_as_and_postal_code_as(String string, String string2) {

    }

    @When("Leaves Last Name field empty")
    public void leaves_last_name_field_empty() {

    }


    @When("The user clicks the Cancel button on the Checkout: Your Information page")
    public void the_user_clicks_the_cancel_button_on_the_checkout_your_information_page() {

    }

    @Then("The user should be redirected to the Your Cart page")
    public void the_user_should_be_redirected_to_the_your_cart_page() {

    }

    @Then("The Back Home button should be visible")
    public void theBackHomeButtonShouldBeVisible() {

    }

    @And("When the user clicks the Back Home button")
    public void whenTheUserClicksTheBackHomeButton() {
    }

    @Then("The user should be redirected to the Products page")
    public void the_user_should_be_redirected_to_the_products_page() {

    }



}
