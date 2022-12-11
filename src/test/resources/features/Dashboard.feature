Feature: Dashboard functionality

  @dashboard
  Scenario: Verify dashboard
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in
    Then user verify dashboard page