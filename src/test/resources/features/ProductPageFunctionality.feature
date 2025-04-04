@productPage
Feature: Product Page - View Products

  Background:
    Given I am logged in and accessed the product page successfully

  Scenario: Verify product list displays items with names, prices, images, and Add to Cart button
    When I see a list of products
    Then each product should have a name, price, image, and an Add to Cart button visible
      | productName   | price  | imageURL                |
      | product1      | $19.99 | /images/product1.jpg     |
      | product2      | $29.99 | /images/product2.jpg     |
      | product3      | $39.99 | /images/product3.jpg     |
      | product4      | $49.99 | /images/product4.jpg     |
      | product5      | $59.99 | /images/product5.jpg     |
      | product6      | $69.99 | /images/product6.jpg     |

  Scenario: Verify sorting by Name (A to Z)
    When I sort products by "Name (A to Z)"
    Then the products should be displayed in ascending alphabetical order

  Scenario: Verify sorting by Name (Z to A)
    When I sort products by "Name (Z to A)"
    Then the products should be displayed in descending alphabetical order

  Scenario: Verify sorting by Price (Low to High)
    When I sort products by "Price (low to high)"
    Then the products should be sorted from lowest to highest price

  Scenario: Verify sorting by Price (High to Low)
    When I sort products by "Price (high to low)"
    Then the products should be sorted from highest to lowest price

  Scenario: Verify product details page
    When I click on a product
    Then I should be redirected to the product details page
