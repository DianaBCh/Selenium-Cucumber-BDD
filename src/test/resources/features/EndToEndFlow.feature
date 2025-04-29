@e2eFlow
Feature: End-to-End Purchase Flow
  As a standard user,
  I want to complete a full purchase and logout,
  So that I can verify that the application works correctly across all major features.

  Scenario: Complete end-to-end purchase and logout flow
    Given the user is on the login page
    When the user logs in with valid credentials
    And the user adds a product to the cart
    And the user proceeds to checkout
    And the user provides valid checkout information
    And the user completes the purchase
    And the user logs out
    Then the user should be redirected to the login page
    And the Products page should not be accessible via browser back button