@UI
Feature: AddUser

  Scenario: Verify navigation to the Sign up page
    Given user is on "loginPage"
    When user clicks sign up button
    Then user is taken to the "signUpPage"
    When user cancels the registration
    Then user is taken to the "loginPage"

  Scenario: User successfully add an account
    Given user is on "signUpPage"
    When user performs registration with valid data
    Then "Contact List" page is displayed
    When user clicks logout button
    Then user is taken to the "loginPage"
