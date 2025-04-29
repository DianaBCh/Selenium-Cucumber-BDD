package com.project.stepDefs;

import com.project.pages.CheckoutFunctionalityPage;
import com.project.pages.LoginFunctionalityPage;
import com.project.pages.ProductFunctionalityPage;
import com.project.utils.ConfigurationReader;
import com.project.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class EndToEndFlowStepDefs {

    LoginFunctionalityPage loginFunctionalityPage = new LoginFunctionalityPage();
    ProductFunctionalityPage productFunctionalityPage = new ProductFunctionalityPage();
    CheckoutFunctionalityPage checkoutFunctionalityPage = new CheckoutFunctionalityPage();

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("swagLabs"));

    }

    @When("the user logs in with valid credentials")
    public void the_user_logs_in_with_valid_credentials() {

        loginFunctionalityPage.login();


    }

    @When("the user adds a product to the cart")
    public void the_user_adds_a_product_to_the_cart() {

        productFunctionalityPage.addItemToCart("Sauce Labs Bolt T-Shirt");

    }

    @When("the user proceeds to checkout")
    public void the_user_proceeds_to_checkout() {

        checkoutFunctionalityPage.cartButton.click();
        checkoutFunctionalityPage.checkoutButton.click();

    }

    @When("the user provides valid checkout information")
    public void the_user_provides_valid_checkout_information() {

        checkoutFunctionalityPage.fillCheckoutForm("John", "Doe", "1234");
        checkoutFunctionalityPage.continueButton.click();

    }

    @When("the user completes the purchase")
    public void the_user_completes_the_purchase() {

        checkoutFunctionalityPage.finishButton.click();
        String actualConfirmationMessage = checkoutFunctionalityPage.thankYouMessage.getText();

        Assert.assertEquals("Thank you for your order!", actualConfirmationMessage);


    }

    @When("the user logs out")
    public void the_user_logs_out() {

        productFunctionalityPage.burgerMenuButton.click();
        productFunctionalityPage.logoutButton.click();

    }

    @Then("the Products page should not be accessible via browser back button")
    public void the_products_page_should_not_be_accessible_via_browser_back_button() {

        Driver.getDriver().navigate().back();  // Simulate browser back button


    }
}
