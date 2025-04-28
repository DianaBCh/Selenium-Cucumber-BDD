Feature: Logout Functionality
  As a logged-in user,
  I want to log out from the system,
  So that I can end my session securely and prevent unauthorized access.

  Background:
    Given user is logged in and accessed the product page successfully

  Scenario: Verify that the Logout button is visible in the navigation menu
    When the user clicks on the burger (☰) menu icon
    Then The Logout button should be visible in the navigation menu

  Scenario: Verify user can log out successfully
    When the user clicks on the burger (☰) menu icon
    And The user clicks on the Logout button
    Then The user should be redirected to the login page

  Scenario: Verify that browser Back button cannot access restricted pages after logout
    When the user clicks on the burger (☰) menu icon
    And The user clicks on the Logout button
    And The user attempts to navigate back using the browser Back button
    Then The user should remain on the login page
    And The Products page should not be accessible

  Scenario: Verify restricted pages are not accessible after logout via URL
    When the user clicks on the burger (☰) menu icon
    And The user clicks on the Logout button
    And The user navigates directly to the Products page via URL
    Then An error message should be displayed: "Epic sadface: You can only access '/inventory.html' when you are logged in."

  Scenario: Verify Logout button remains consistent across different pages
    When the user navigates to the Products page
    And The user checks the burger (☰) menu
    Then The Logout button should be visible
    When the user navigates to the Cart page
    And The user checks the burger (☰) menu
    Then The Logout button should be visible
    When the user navigates to the Checkout page
    And The user checks the burger (☰) menu
    Then The Logout button should be visible