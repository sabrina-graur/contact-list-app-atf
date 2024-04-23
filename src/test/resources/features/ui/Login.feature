@UI
Feature: Login

  Background:
    Given user is on Login page

  Scenario: Check login with valid data
    When user logs in with the following credentials:
      | email    | rina.nakl.nimb@gmail.com |
      | password | testrinaaacount          |
    Then "Contact List" page is displayed

  @Negative
  Scenario Outline: Check login with invalid data
    When user logs in with the following credentials:
      | email    | <email>    |
      | password | <password> |
    Then "Incorrect username or password" message is displayed
    Examples:
      | email                    | password        |
      | r                        | testrinaaacount |
      |                          | testrinaaacount |
      | rina.nakl.nimb@gmail.com | @               |
      | rina.nakl.nimb@gmail.com |                 |
