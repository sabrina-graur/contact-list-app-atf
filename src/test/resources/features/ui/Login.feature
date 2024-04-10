@UI
Feature: Login

  Background:
    Given user is on "loginPage"

  Scenario: Check login
    When user logs in with valid credentials
    Then user is taken to the "contactListPage"

  @Negative
  Scenario: Check login with invalid data
    When user logs in with invalid credentials
    Then "Incorrect username or password" error message is displayed
