Feature: Product Page - View Products

  Scenario: Verify product list displays items with names, prices, images, and "Add to Cart" button
    Given I am logged in as a standard user
    When I navigate to the product page
    Then I should see a list of products
    And each product should have a name, price, image, and an "Add to Cart" button

  Scenario: Verify sorting by Name (A to Z)
    Given I am on the product page
    When I sort products by "Name (A to Z)"
    Then the products should be displayed in ascending alphabetical order

  Scenario: Verify sorting by Name (Z to A)
    Given I am on the product page
    When I sort products by "Name (Z to A)"
    Then the products should be displayed in descending alphabetical order

  Scenario: Verify sorting by Price (Low to High)
    Given I am on the product page
    When I sort products by "Price (low to high)"
    Then the products should be sorted from lowest to highest price

  Scenario: Verify sorting by Price (High to Low)
    Given I am on the product page
    When I sort products by "Price (high to low)"
    Then the products should be sorted from highest to lowest price

  Scenario: Verify product details page
    Given I am on the product page
    When I click on a product
    Then I should be redirected to the product details page
    And I should see the product name, price, description, and an "Add to Cart" button
