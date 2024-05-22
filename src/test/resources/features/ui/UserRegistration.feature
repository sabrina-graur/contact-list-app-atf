@UI
Feature: User Registration via UI

  Background:
    Given user is on Sign Up page

  Scenario: User successfully creates an account
    When user performs registration
    Then "Contact List" page is displayed

  Scenario: Check that registration can be canceled
    When user cancels the registration
    Then "Contact List App" is displayed
