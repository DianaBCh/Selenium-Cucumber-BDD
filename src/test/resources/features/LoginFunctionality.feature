@login
Feature: Login functionality for registered users

  Background:
    Given I am on the login page
  # Test Case 1: Verify login page has username and password fields
  Scenario: Verify that the login page has fields for username and password
    Then I should see the username field
    And I should see the password field

  # Test Case 2: Verify login with valid credentials
  Scenario: Verify that the user can log in with valid credentials
    When I enter valid username and password
    And I click on the login button
    Then I should be redirected to the dashboard

  # Test Case 3: Verify login with invalid credentials
  Scenario: Verify that the user cannot log in with invalid credentials
    When I enter invalid username and password
    And I click on the login button
    Then I should see "Username and password do not match any user in this service" error message

  # Test Case 4: Verify error message for missing username
  Scenario: Verify that the user sees an error message when no username is entered
    When I leave the username field empty
    And I enter a valid password
    And I click on the login button
    Then I should see "Username is required" error message


  # Test Case 5: Verify error message for missing password
  Scenario: Verify that the user sees an error message when no password is entered
    When I enter a valid username
    And I leave the password field empty
    And I click on the login button
    Then I should see "Password is required" error message

  # Test Case 6: Verify error message for missing username and missing password
  Scenario: Empty username and empty password
    When I leave the username and password fields empty
    Then I should see the error message "Username is required"

