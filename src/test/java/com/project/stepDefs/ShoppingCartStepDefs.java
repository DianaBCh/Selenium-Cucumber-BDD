package com.project.stepDefs;

import com.project.pages.ProductFunctionalityPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ShoppingCartStepDefs {

    ProductFunctionalityPage productFunctionalityPage = new ProductFunctionalityPage();

    private String itemName;


    @When("the user adds {string} to the cart")
    public void the_user_adds_to_the_cart(String item) {
        itemName = item;
        productFunctionalityPage.addItemToCart(item);

    }

    @And("the cart badge should show {string}")
    public void the_cart_badge_should_show(String expectedCount) {

        String actualCount = productFunctionalityPage.getCartBadgeCount();
        Assert.assertEquals("Badge number is not as expected!", expectedCount,
                            actualCount);

    }

    @Then("the button for the item should display {string}")
    public void theButtonForTheItemShouldDisplay(String expectedTextButton) {

        String actualTextButton = productFunctionalityPage.getButtonTextForItem(itemName);
        Assert.assertEquals("Button text is not changed!", expectedTextButton,
                            actualTextButton);

    }

    @When("the user adds the following items to the cart:")
    public void the_user_adds_the_following_items_to_the_cart(List<String> items) {

        for (String item : items) {
            productFunctionalityPage.addItemToCart(item);
        }

    }


    @And("the user removes {string} from the cart")
    public void the_user_removes_from_the_cart(String item) {

        itemName=item;

        productFunctionalityPage.removeItemFromCart(item);

    }

    @Then("the product is no longer listed")
    public void the_product_is_no_longer_listed() {


        Assert.assertFalse("Expected the product to be removed from the cart, but it was still listed.",
                productFunctionalityPage.isLastRemovedItemDisplayed());

    }


    @Then("the button for {string} should display {string}")
    public void the_button_for_should_display(String itemName, String expectedTextButton) {

        productFunctionalityPage.getAddOrRemoveButton(itemName);
        Assert.assertEquals("Button text mismatch!", expectedTextButton,
                           productFunctionalityPage.getButtonTextForItem(itemName));

    }


}
