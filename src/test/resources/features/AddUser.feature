#@UI
Feature: AddUser

  Scenario: Add user
    Given user navigates to "signUpPage"
    When user performs registration with valid data
    Then user is taken to the "contactListPage"
#    And the following elements are displayed:          should I add this???

    When user clicks logout button
    Then user is taken to the "loginPage"
