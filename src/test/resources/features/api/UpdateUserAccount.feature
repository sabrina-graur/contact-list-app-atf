@API
Feature: Update User Account

  @DeleteAccount
  Scenario: Validate that user can update an account
    Given user has a registered account with the following USER_CREDENTIALS:
      | firstName | Selina                    |
      | lastName  | Kyle                      |
      | email     | cat.selina.kyle@gmail.com |
      | password  | meowMeow                  |
    When user updates the account with the following data:
      | firstName | Cat                  |
      | lastName  | Woman                |
      | email     | cat.woman!@gmail.com |
      | password  | meowMeow             |
    Then response has status code 200
    And the new account is updated
