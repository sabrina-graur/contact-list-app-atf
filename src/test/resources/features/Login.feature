@UI
Feature: Login

  Scenario: Check login
    Given user navigates to "loginPage"
    When user logs in with valid credentials
    Then user is taken to the "contactListPage"

  Scenario: Check login with invalid data
    Given user navigates to "loginPage"
    When user logs in with invalid credentials
    Then "Incorrect username or password" error message is displayed
