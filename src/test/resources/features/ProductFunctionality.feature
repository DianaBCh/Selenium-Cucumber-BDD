@productPage
Feature: Product Page - View Products

  Background:
    Given I am logged in and accessed the product page successfully

  Scenario: Verify product list displays items with names, prices, images, and Add to Cart button
    When I see a list of products
    Then each product should have a name, price, image, and an Add to Cart button visible
      | Sauce Labs Backpack              | $29.99 | /static/media/sauce-backpack-1200x1500.0a0b85a3.jpg|
      | Sauce Labs Bike Light            | $9.99  | /static/media/bike-light-1200x1500.37c843b0.jpg    |
      | Sauce Labs Bolt T-Shirt          | $15.99 | /static/media/bolt-shirt-1200x1500.c2599ac5.jpg    |
      | Sauce Labs Fleece Jacket         | $49.99 | /static/media/sauce-pullover-1200x1500.51d7ffaf.jpg|
      | Sauce Labs Onesie                | $7.99  | /static/media/red-onesie-1200x1500.2ec615b2.jpg    |
      | Test.allTheThings() T-Shirt (Red)| $15.99 | /static/media/red-tatt-1200x1500.30dadef4.jpg      |

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
