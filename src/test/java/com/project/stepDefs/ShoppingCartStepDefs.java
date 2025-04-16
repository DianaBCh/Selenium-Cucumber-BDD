package com.project.stepDefs;

import com.project.pages.ProductFunctionalityPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ShoppingCartStepDefs {

    ProductFunctionalityPage productFunctionalityPage = new ProductFunctionalityPage();

    private String itemName;


    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String item) {
        itemName=item;
        productFunctionalityPage.addItemToCart(itemName);

    }

    @Then("the cart badge should show {string}")
    public void the_cart_badge_should_show(String expectedCount) {

        String actualCount = productFunctionalityPage.getCartBadgeCount();
        Assert.assertEquals("Badge number is not as expected!", expectedCount, actualCount);

    }

    @And("the button for the item should display {string}")
    public void theButtonForTheItemShouldDisplay(String expectedTextButton) {

        String actualTextButton = productFunctionalityPage.getButtonTextForItem(itemName);
        Assert.assertEquals("Button text is not changed!", expectedTextButton,actualTextButton);

    }

    @When("the user adds the following items to the cart:")
    public void the_user_adds_the_following_items_to_the_cart( DataTable dataTable) {

    }



    @When("the user removes {string} from the cart")
    public void the_user_removes_from_the_cart(String string) {

    }

    @Then("the cart badge should not be visible")
    public void the_cart_badge_should_not_be_visible() {

    }



    @Then("the product is no longer listed")
    public void the_product_is_no_longer_listed() {

    }


    @Then("the button for {string} should display {string}")
    public void the_button_for_should_display(String string, String string2) {

    }



}
