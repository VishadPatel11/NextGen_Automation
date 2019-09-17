Feature:  Squarespace Login error

  Scenario Outline: Verify that user is not able to login with  invalid username and password


    Given User is on Squarespace Login page
    When user enters invalid "<username>" and "<password>"
    And user clicks Login button
    Then Error msg is displayed

    Examples:
      |username                         |password     |
      |squarespaceqa9@squarespace.com   |K}PrbuTLyf6x |
#     |vishad                           |Password01234|



