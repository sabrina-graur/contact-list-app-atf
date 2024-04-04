@UI
Feature: AddUser

  Scenario: Add user
    Given user navigates to "signUpPage"
    When user performs registration with valid data
    Then user is taken to the "contactListPage"
    When user clicks logout button
    Then user is taken to the "loginPage"
