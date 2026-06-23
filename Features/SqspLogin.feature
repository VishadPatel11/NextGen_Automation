Feature: Login error

  Scenario Outline: Verify that user is not able to login with  invalid username and password


    Given User is on Login page
    When user enters invalid "<username>" and "<password>"
    And user clicks Login button
    Then Error msg is displayed

    Examples:
      |username                |password          |
      |invalid@example.com     |invalid_password  |
#     |vishad                  |Password01234     |



