@logout
Feature: Logout Functionality
  As a logged-in user,
  I want to log out from the system,
  So that I can end my session securely and prevent unauthorized access.

  Background:
    Given user is logged in and accessed the product page successfully

  Scenario: Verify that the Logout button is visible in the navigation menu
    When the user clicks on the burger (☰) menu icon
    Then the Logout button should be visible in the navigation menu

  Scenario: Verify user can log out successfully
    When the user clicks on the burger (☰) menu icon
    And the user clicks on the Logout button
    Then the user should be redirected to the login page

  Scenario: Verify that browser Back button cannot access restricted pages after logout
    When the user clicks on the burger (☰) menu icon
    And the user clicks on the Logout button
    And the user attempts to navigate back using the browser Back button
    Then the user should remain on the login page
    And the Products page should not be accessible

  Scenario Outline: Verify restricted pages are not accessible after logout via URL
    When the user clicks on the burger (☰) menu icon
    And the user clicks on the Logout button
    And the user navigates directly to "<Page Name>" via URL
    Then an error message should be displayed: "Epic sadface: You can only access '<Page URL>' when you are logged in."

    Examples:
      | Page Name             | Page URL                  |
      | Products              | /inventory.html           |
      | Your Cart             | /cart.html                |
      | Checkout Information  | /checkout-step-one.html   |
      | Checkout Overview     | /checkout-step-two.html   |
      | Checkout Complete     | /checkout-complete.html   |

  Scenario Outline: Verify Logout button remains consistent across different pages
    When the user navigates to the <Page> page
    And the user checks the burger (☰) menu
    Then the Logout button should be visible

    Examples:
      | Page     |
      | Products |
      | Cart     |
      | Checkout |