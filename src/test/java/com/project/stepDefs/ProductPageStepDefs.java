package com.project.stepDefs;

import com.project.pages.LoginFunctionalityPage;
import com.project.pages.ProductFunctionalityPage;
import com.project.utils.BrowserUtils;
import com.project.utils.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        wait.until(ExpectedConditions.visibilityOfAllElements(productFunctionalityPage.itemNames));

        // Assert that the list is not empty
        assertTrue("The product list is empty!", !productFunctionalityPage.itemNames.isEmpty());
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
            System.out.println("Actual Product Name: " + productFunctionalityPage.itemNames.get(i).getText());

            assertEquals(productFunctionalityPage.itemNames.get(i).getText(), expectedProductName);


            // Verify price
            System.out.println("Expected Price: " + expectedProductPrice);
            System.out.println("Actual Price: " + productFunctionalityPage.itemPrices.get(i).getText());

            assertEquals(productFunctionalityPage.itemPrices.get(i).getText(), expectedProductPrice);

            // Verify image
            System.out.println("Expected Image URL: " + expectedProductImage);
            System.out.println("Actual Image src: " + productFunctionalityPage.productImages.get(i).getAttribute("src"));

            assertTrue(productFunctionalityPage.productImages.get(i).getAttribute("src").contains(expectedProductImage));


            // Verify "Add to Cart" button visibility
            assertTrue(productFunctionalityPage.addToCartButtons.get(i).isDisplayed());


        }

    }

    @When("I sort products by {string}")
    public void iSortProductsBy(String sortOption) {

        Select dropdown = new Select(productFunctionalityPage.sortProductContainer);
        dropdown.selectByVisibleText(sortOption);

    }

    @Then("the products should be displayed in {string} order")
    public void theProductsShouldBeDisplayedInOrder(String expectedOrder) {

       if (expectedOrder.equals("ascending") || expectedOrder.equals("descending")) {
           List<WebElement> productElements = productFunctionalityPage.itemNames;
           List<String> productNames = new ArrayList<>();
           for (WebElement item : productElements) {
                 productNames.add(item.getText());
           }




           List<String> sorted = new ArrayList<>(productNames);
           Collections.sort(sorted);
           if (expectedOrder.equals("descending")) {
               Collections.reverse(sorted);
           }

           System.out.println("Actual names: " + productNames);
           System.out.println("Expected: " + sorted);
           assertEquals(sorted, productNames);


       }else if (expectedOrder.equals("priceAscending") || expectedOrder.equals("priceDescending")){


           List<WebElement> priceElements = productFunctionalityPage.itemPrices;
           List<Double> actualPrices = new ArrayList<>();
           for (WebElement item : priceElements) {
                  String priceText = item.getText().replace("$", "");
                  actualPrices.add(Double.parseDouble(priceText));

           }



           List<Double> sortedPrices = new ArrayList<>(actualPrices);
           Collections.sort(sortedPrices);
           if (expectedOrder.equals("priceDescending")) {
               Collections.reverse(sortedPrices);
           }

           System.out.println("Actual prices: " + actualPrices);
           System.out.println("Expected: " + sortedPrices);
           assertEquals(sortedPrices, actualPrices);
       }

    }

    @When("I click on {string}")
    public void iClickOn(String productName) {


        productFunctionalityPage.setProductElement(productName);

    }

    @Then("I should be redirected to the {string} details page")
    public void iShouldBeRedirectedToTheDetailsPage(String productName) {

        BrowserUtils.sleep(3);

        String actualProductName = productFunctionalityPage.productDetailsName.getText();
        System.out.println("Actual Product Name: " + actualProductName);
        System.out.println("Expected Product Name: " + productName);
        assertEquals(productName, actualProductName);

    }

}
