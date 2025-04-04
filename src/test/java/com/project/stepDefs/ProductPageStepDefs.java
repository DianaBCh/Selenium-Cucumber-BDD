package com.project.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductPageStepDefs {

    @Given("I am logged in and accessed the product page successfully")
    public void iAmLoggedInAndAccessedTheProductPageSuccessfully() {
    }

    @When("I see a list of products")
    public void iSeeAListOfProducts() {
    }

    @Then("each product should have a name, price, image, and an Add to Cart button visible")
    public void eachProductShouldHaveANamePriceImageAndAnAddToCartButtonVisible(DataTable products) {
    }

    @When("I sort products by {string}")
    public void i_sort_products_by(String string) {

    }
    @Then("the products should be displayed in ascending alphabetical order")
    public void the_products_should_be_displayed_in_ascending_alphabetical_order() {

    }


    @Then("the products should be displayed in descending alphabetical order")
    public void the_products_should_be_displayed_in_descending_alphabetical_order() {

    }



    @Then("the products should be sorted from lowest to highest price")
    public void the_products_should_be_sorted_from_lowest_to_highest_price() {

    }


    @Given("I am on the product page")
    public void i_am_on_the_product_page() {

    }

    @Then("the products should be sorted from highest to lowest price")
    public void the_products_should_be_sorted_from_highest_to_lowest_price() {

    }

    @When("I click on a product")
    public void i_click_on_a_product() {

    }
    @Then("I should be redirected to the product details page")
    public void i_should_be_redirected_to_the_product_details_page() {

    }



}
