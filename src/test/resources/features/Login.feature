Feature: US 101 - Login functionality

  @test1 @validLogin
  Scenario: Valid admin login
    When user enters valid username and valid password
    And user clicks on login button
    Then user is successfully logged in

    @invalidLogin
    Scenario: Invalid admin login
      When user enters invalid username and password
      And user clicks on login button
      Then verify the error message
