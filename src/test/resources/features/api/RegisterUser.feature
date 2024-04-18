@API
Feature: RegisterUser

  Scenario: User successfully creates an account
    Given user performs registration with the valid data:
      | firstName | lastName | email                        | password |
      | Selina    | Kyle     | selina.tryformo225@gmail.com | meowMeow |
#      | Selina    | Kyle     | selina.kyle@gmail.com | meowMeow |
    And response has status code 201
    When user validates the newly created account
    Then response has status code 200

  @Negative
  Scenario Outline: Validate registration with invalid data
    When user performs registration with the invalid data:
      | firstName   | lastName   | email   | password   |
      | <firstName> | <lastName> | <email> | <password> |
    Then response has status code 400
    And <errorMessage> error message is displayed:
    Examples:
      | firstName | lastName | email                   | password | errorMessage          |
      |           | Black    | nick.black@gmail.com    | 12345678 | EMPTY_FIRST_NAME      |
      | Nick      |          | nick.white@gmail.com    | 12345678 | EMPTY_LAST_NAME       |
      | Nick      | White    |                         | 12345678 | EMPTY_EMAIL           |
      | Nick      | Blue     | nick.blue@gmail.com     |          | EMPTY_PASSWORD        |
      | Nick      | Blue     | selina.tryfor@gmail.com | 12345678 | DUPLICATE_EMAIL       |
      | Nick      | Blue     | nick.blue@gmail.com     | 123      | WRONG_PASSWORD_LENGTH |

#  Scenario: Validate that user can update personal data
#    Given user registered an account
#    When user updates details with the following data:
#      | firstName | lastName | email | password |
#      | 100       |          |       |          |
#    Then response has status code 200