Feature: Shopping Cart Functionality

  Background:
    Given I am logged in and accessed the product page successfully

  Scenario: Verify user can add single item to cart
    When the user adds "Sauce Labs Backpack" to the cart
    Then the cart badge should show "1"
    And the "Add to cart" button should change to "Remove"

  Scenario: Verify user can add multiple items to cart
    When the user adds the following items to the cart:
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Backpack      |
    Then the cart badge should show "3"

  Scenario: Verify cart badge updates correctly
    When the user adds "Sauce Labs Bolt T-Shirt" to the cart
    Then the cart badge should show "1"
    When the user removes "Sauce Labs Bolt T-Shirt" from the cart
    Then the cart badge should not be visible

  Scenario: Verify user can remove item from cart
    And the user adds "Test.allTheThings() T-Shirt (Red)" to the cart
    When the user removes "Test.allTheThings() T-Shirt (Red)" from the cart
    Then the product is no longer listed

  Scenario: Verify if "Add to Cart" button changes to "Remove"
    When the user adds "Sauce Labs Bike Light" to the cart
    Then the button for "Sauce Labs Bike Light" should display "Remove"