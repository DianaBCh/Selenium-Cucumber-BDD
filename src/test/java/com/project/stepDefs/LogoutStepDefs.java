package com.project.stepDefs;

import com.project.pages.LoginFunctionalityPage;
import com.project.pages.ProductFunctionalityPage;
import com.project.utils.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LogoutStepDefs {

    ProductFunctionalityPage productFunctionalityPage = new ProductFunctionalityPage();
    LoginFunctionalityPage loginFunctionalityPage = new LoginFunctionalityPage();
    private String baseURL = "https://www.saucedemo.com";

    @When("the user clicks on the burger \\(☰) menu icon")
    public void the_user_clicks_on_the_burger_menu_icon() {

        productFunctionalityPage.burgerMenuButton.click();

    }
    @Then("the Logout button should be visible in the navigation menu")
    public void the_logout_button_should_be_visible_in_the_navigation_menu() {

        Assert.assertTrue("Logout button is not present!", productFunctionalityPage.logoutButton.isDisplayed());

    }

    @When("the user clicks on the Logout button")
    public void the_user_clicks_on_the_logout_button() {

        productFunctionalityPage.logoutButton.click();

    }
    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {

        String currentUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("User is not on the login page!","https://www.saucedemo.com/", currentUrl);

    }

    @When("the user attempts to navigate back using the browser Back button")
    public void the_user_attempts_to_navigate_back_using_the_browser_back_button() {

        Driver.getDriver().navigate().back();  // Simulate browser back button

    }
    @Then("the user should remain on the login page")
    public void the_user_should_remain_on_the_login_page() {

        Assert.assertEquals("User is not on the login page after pressing back!","https://www.saucedemo.com/", Driver.getDriver().getCurrentUrl());

    }
    @Then("the Products page should not be accessible")
    public void the_products_page_should_not_be_accessible() {

        //confirm a login page element is visible, that means is still on login page
        Assert.assertTrue("Login button not found - User might be on a restricted page!",
                Driver.getDriver().findElement(By.id("login-button")).isDisplayed());

    }

    @When("the user navigates directly to {string} via URL")
    public void the_user_navigates_directly_to_via_url(String pageURL) {

        Driver.getDriver().get(baseURL+pageURL);

    }
    @Then("an error message should be displayed: {string}")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {

        String actualErrorMessage = loginFunctionalityPage.errorMessage.getText();

        Assert.assertEquals("Error message mismatch", expectedErrorMessage, actualErrorMessage);

    }

    @When("the user navigates to the {string} page")
    public void theUserNavigatesToThePage(String pageName) {

        String targetUrl = "";

        switch (pageName.toLowerCase()) {
            case "products":
                targetUrl = baseURL + "/inventory.html";
                break;
            case "cart":
                targetUrl = baseURL + "/cart.html";
                break;
            case "checkout: your information":
                targetUrl = baseURL + "/checkout-step-one.html";
                break;
            case "checkout: overview":
                targetUrl = baseURL + "/checkout-step-two.html";
                break;
            case "checkout: complete!":
                targetUrl = baseURL + "/checkout-complete.html";
                break;
            default:
                throw new IllegalArgumentException("Unknown page name: " + pageName);
        }
    }


}
