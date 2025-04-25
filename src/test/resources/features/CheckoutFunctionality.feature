
@checkout
Feature: Checkout Functionality
  As a registered user,
  I want to complete a checkout process after adding items to the cart,
  So that I can purchase the selected products successfully.

  Background:
    Given user is logged in and accessed the product page successfully


  @positive
  Scenario: Verify checkout with valid information is successful
    When the user adds "Sauce Labs Backpack" to the cart
    And The user navigates to the checkout page
    When The user fills in First Name as "John", Last Name as "Doe", and Postal Code as "12345"
    And The user clicks the Continue button
    Then The user should be redirected to the Overview page
    And The Finish button should be displayed

  @negative
  Scenario: Verify that the system prevents proceeding with empty fields
    When the user adds the following items to the cart:
      | Sauce Labs Onesie                |
      | Sauce Labs Fleece Jacket         |
      | Sauce Labs Backpack              |
      | Test.allTheThings() T-Shirt (Red)|
    And The user navigates to the checkout page
    And The user clicks the Continue button
    Then An error message should be displayed: "Error: First Name is required"


  @negative
  Scenario: Verify validation works when only First Name and Last Name are filled
    When the user adds "Sauce Labs Fleece Jacket" to the cart
    And The user navigates to the checkout page
    And The user fills First Name as "John" and Last Name as "Doe"
    And Leaves Postal Code field empty
    And The user clicks the Continue button
    Then An error message should be displayed: "Error: Postal Code is required"

  @negative
  Scenario: Verify validation works when only Last Name and Zip/Postal Code are filled
    When the user adds "Sauce Labs Fleece Jacket" to the cart
    And The user navigates to the checkout page
    And The user fills Last Name as "Doe" and Postal Code as "12345"
    And Leaves First Name field empty
    And The user clicks the Continue button
    Then An error message should be displayed: "Error: First Name is required"

  @negative
  Scenario: Verify validation works when only First Name and Zip/Postal Code are filled
    When the user adds "Sauce Labs Fleece Jacket" to the cart
    And The user navigates to the checkout page
    And The user fills First Name as "John" and Postal Code as "12345"
    And Leaves Last Name field empty
    And The user clicks the Continue button
    Then An error message should be displayed: "Error: Last Name is required"


  @negative
  Scenario: Verify user can cancel the order and return to cart
    When the user adds the following items to the cart:
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Backpack      |
    And The user navigates to the checkout page
    And The user clicks the Cancel button on the Checkout: Your Information page
    Then The user should be redirected to the Your Cart page

  @positive
  Scenario: Verify the user can place the order successfully
    When the user adds the following items to the cart:
      | Sauce Labs Onesie        |
      | Sauce Labs Fleece Jacket |
    And The user navigates to the checkout page
    And The user fills in First Name as "John", Last Name as "Doe", and Postal Code as "12345"
    And The user clicks the Continue button
    And The user clicks the Finish button
    Then The user should see a confirmation message "Thank you for your order!"


  Scenario: Verify Back Home button is present and functional after finishing Checkout
    When the user adds "Sauce Labs Bike Light" to the cart
    And The user navigates to the checkout page
    And The user fills in First Name as "John", Last Name as "Doe", and Postal Code as "12345"
    And The user clicks the Continue button
    And The user clicks the Finish button
    Then The Back Home button should be visible
    And When the user clicks the Back Home button
    Then The user should be redirected to the Products page
