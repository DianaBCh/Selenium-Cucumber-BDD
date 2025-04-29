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
    And the user navigates directly to "<Page URL>" via URL
    Then an error message should be displayed: "<Expected Error Message>"

    Examples:
      | Page URL                 | Expected Error Message                                                   |
      | /inventory.html          | Epic sadface: You can only access '/inventory.html' when you are logged in. |
      | /cart.html               | Epic sadface: You can only access '/cart.html' when you are logged in.      |
      | /checkout-step-one.html  | Epic sadface: You can only access '/checkout-step-one.html' when you are logged in. |
      | /checkout-step-two.html  | Epic sadface: You can only access '/checkout-step-two.html' when you are logged in. |
      | /checkout-complete.html  | Epic sadface: You can only access '/checkout-complete.html' when you are logged in. |


  Scenario Outline: Verify Logout button remains consistent across different pages
    When the user navigates to the "<PageName>" page
    And the user clicks on the burger (☰) menu icon
    Then the Logout button should be visible in the navigation menu

    Examples:
      | PageName                   |
      | Products                   |
      | Cart                       |
      | Checkout: Your Information |
      | Checkout: Overview         |
      | Checkout: Complete!        |