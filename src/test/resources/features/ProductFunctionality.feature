@productPage
Feature: Product Page - View Products

  Background:
    Given user is logged in and accessed the product page successfully

  Scenario: Verify product list displays items with names, prices, images, and Add to Cart button
    When I see a list of products
    Then each product should have a name, price, image, and an Add to Cart button visible
      | Sauce Labs Backpack              | $29.99 | /static/media/sauce-backpack-1200x1500.0a0b85a3.jpg|
      | Sauce Labs Bike Light            | $9.99  | /static/media/bike-light-1200x1500.37c843b0.jpg    |
      | Sauce Labs Bolt T-Shirt          | $15.99 | /static/media/bolt-shirt-1200x1500.c2599ac5.jpg    |
      | Sauce Labs Fleece Jacket         | $49.99 | /static/media/sauce-pullover-1200x1500.51d7ffaf.jpg|
      | Sauce Labs Onesie                | $7.99  | /static/media/red-onesie-1200x1500.2ec615b2.jpg    |
      | Test.allTheThings() T-Shirt (Red)| $15.99 | /static/media/red-tatt-1200x1500.30dadef4.jpg      |

  Scenario Outline: Verify product sorting
    When I sort products by "<sortOption>"
    Then the products should be displayed in "<expectedOrder>" order

    Examples:
      | sortOption          | expectedOrder     |
      | Name (A to Z)       | ascending         |
      | Name (Z to A)       | descending        |
      | Price (low to high) | priceAscending    |
      | Price (high to low) | priceDescending   |

  Scenario Outline: Verify product details page for each item
    When I click on "<productName>"
    Then I should be redirected to the "<productName>" details page

    Examples:
      | productName                     |
      |Sauce Labs Backpack              |
      |Sauce Labs Bike Light            |
      |Sauce Labs Bolt T-Shirt          |
      |Sauce Labs Fleece Jacket         |
      |Sauce Labs Onesie                |
      |Test.allTheThings() T-Shirt (Red)|
