Feature: US - 104 -  Search Employee Functionality

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    And click on PIM option
    When click on Employee List from menu
  @search @id
  Scenario: Searching employee by id
    And user enter the id of this employee
    And click on search button
    Then verify the employee

  @search @name
  Scenario: Searching employee by name

    And user enter the name of this employee
    And click on search button
    Then verify the employee

