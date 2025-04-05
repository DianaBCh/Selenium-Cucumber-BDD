package com.project.stepDefs;

import com.project.pages.LoginFunctionalityPage;
import com.project.pages.ProductFunctionalityPage;
import com.project.utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductPageStepDefs {

    LoginFunctionalityPage loginFunctionalityPage = new LoginFunctionalityPage();

    ProductFunctionalityPage productFunctionalityPage  = new ProductFunctionalityPage();

    @Given("I am logged in and accessed the product page successfully")
    public void iAmLoggedInAndAccessedTheProductPageSuccessfully() {

        loginFunctionalityPage.login();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        String actualURL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals("User is NOT on the dashboard page!", expectedURL, actualURL);

    }

    @When("I see a list of products")
    public void iSeeAListOfProducts() {

        // Wait until the product list is visible
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productFunctionalityPage.productNames));

        // Assert that the list is not empty
        assertTrue("The product list is empty!", !productFunctionalityPage.productNames.isEmpty());
    }

    @Then("each product should have a name, price, image, and an Add to Cart button visible")
    public void eachProductShouldHaveANamePriceImageAndAnAddToCartButtonVisible(DataTable dataTable) {

        List<List<String>> products = dataTable.asLists(String.class);
        for (int i = 0; i < products.size(); i++) {
            //extracting expected data from DataTable
            String expectedProductName = products.get(i).get(0);
            String expectedProductPrice = products.get(i).get(1);
            String expectedProductImage = products.get(i).get(2);

            // Verify name
            System.out.println("Expected Product Name: " + expectedProductName);
            System.out.println("Actual Product Name: " + productFunctionalityPage.productNames.get(i).getText());

            assertEquals(productFunctionalityPage.productNames.get(i).getText(), expectedProductName);


            // Verify price
            System.out.println("Expected Price: " + expectedProductPrice);
            System.out.println("Actual Price: " + productFunctionalityPage.productPrices.get(i).getText());

            assertEquals(productFunctionalityPage.productPrices.get(i).getText(), expectedProductPrice);

            // Verify image
            System.out.println("Expected Image URL: " + expectedProductImage);
            System.out.println("Actual Image src: " + productFunctionalityPage.productImages.get(i).getAttribute("src"));

            assertTrue(productFunctionalityPage.productImages.get(i).getAttribute("src").contains(expectedProductImage));


            // Verify "Add to Cart" button visibility
            assertTrue(productFunctionalityPage.addToCartButtons.get(i).isDisplayed());


        }


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
