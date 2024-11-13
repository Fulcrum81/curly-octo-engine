Feature: Login
  Scenario Outline: Login with incorrect credentials
    Given User is on login page
    When User enters <email> in email input
    And User enters <password> in password input
    And User clicks login button
    Then Error message appears
    And Error message contains "Wrong password or the account is disabled, or does not exist" text

    Examples:
    | email                      | password    |
    | "vadim.zubovich@gmail.com" | "qwertt"    |
    | "lavbghdv"                 | "Test1234!" |
    | "lksjavhbkjsdvdf"          | "kjcdbsbc"  |