@API
Feature: User Registration via API

  @DeleteAccount
  Scenario: Validate registration with valid data
    Given the following credentials:
      | firstName | Selina                    |
      | lastName  | Kyle                      |
      | email     | cat.selina.kyle@gmail.com |
      | password  | meowMeow                  |
    When user registers an account
    Then response has status code 201
    And the new account is created

  @Negative
  Scenario Outline: Validate registration with invalid data
    Given the following credentials:
      | firstName | <firstName> |
      | lastName  | <lastName>  |
      | email     | <email>     |
      | password  | <password>  |
    When user registers an account
    Then response has status code 400
    And <errorMessage> error message is displayed
    Examples:
      | firstName | lastName | email                   | password | errorMessage          |
      |           | Black    | nick.black@gmail.com    | 12345678 | EMPTY_FIRST_NAME      |
      | Nick      |          | nick.white@gmail.com    | 12345678 | EMPTY_LAST_NAME       |
      | Nick      | White    |                         | 12345678 | EMPTY_EMAIL           |
      | Nick      | Blue     | nick.blue@gmail.com     |          | EMPTY_PASSWORD        |
      | Nick      | Blue     | selina.tryfor@gmail.com | 12345678 | DUPLICATE_EMAIL       |
      | Nick      | Blue     | nick.blue@gmail.com     | 123      | WRONG_PASSWORD_LENGTH |
