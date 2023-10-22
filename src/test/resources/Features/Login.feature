Feature: Login in the application
  Scenario: Login to application as Valid user
    Given user is on saucedemo login page
    When user enter the valid credentials
    And user click login
    Then home page should be displayed

  Scenario: Login to applications as Invalid user
    Given user is on saucedemo login page
    When user enter the invalid credentials
    And user click login
    Then error message should be displayed
