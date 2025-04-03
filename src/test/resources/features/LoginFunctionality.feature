@login
Feature: Login functionality for registered users

  Background:
    Given I am on the login page
  # Test Case 1: Verify login page has username and password fields
  Scenario: Verify that the login page has fields for username and password
    Then I should see the username field
    And I should see the password field

  # Test Case 2: Verify login with valid credentials
  Scenario Outline: Verify that the user can log in with valid credentials
    When I enter valid username as "<username>" and valid password as "<password>"
    And I click on the login button
    Then I should be redirected to the dashboard

    Examples:
    |username               |password    |
    |standard_user          |secret_sauce|
    |problem_user           |secret_sauce|
    |performance_glitch_user|secret_sauce|
    |error_user             |secret_sauce|
    |visual_user            |secret_sauce|

  # Test Case 3: Verify login with invalid credentials
  Scenario Outline: Verify that the user cannot log in with invalid credentials
    When I enter invalid username "<username>" and invalid password "<password>"
    And I click on the login button
    Then I should see "Epic sadface: Username and password do not match any user in this service" error message
    Examples:
    |username     |password    |
    |standard.user|secret.sauce|
    |problem.user |secret-sauce|
    |error-user   |secret;sauce|

  # Test Case 4: Verify error message for missing username
  Scenario: Verify that the user sees an error message when no username is entered
    When I leave the username field empty
    And I enter a valid password "secret_sauce"
    And I click on the login button
    Then I should see "Epic sadface: Username is required" error message


  # Test Case 5: Verify error message for missing password
  Scenario: Verify that the user sees an error message when no password is entered
    When I enter a valid username "standard_user"
    And I leave the password field empty
    And I click on the login button
    Then I should see "Epic sadface: Password is required" error message

  # Test Case 6: Verify error message for missing username and missing password
  Scenario: Empty username and empty password
    When I leave the username and password fields empty
    And I click on the login button
    Then I should see "Epic sadface: Username is required" error message

  # Test Case 7: Verify error message locked user
  Scenario: Verify that a locked user cannot log in
    Given I am on the login page
    When I enter valid username as "locked_out_user" and valid password as "secret_sauce"
    And I click on the login button
    Then I should see "Epic sadface: Sorry, this user has been locked out." error message

