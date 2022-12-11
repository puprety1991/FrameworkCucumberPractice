Feature: US 103 - Adding new employees

  Background:
    When user enters valid username and valid password
    And user clicks on login button
    And click on PIM option
    When click on AddEmployee from menu

  @addingEmployee @test1
  Scenario: Adding one employee
    And user enter the firstname and lastname
    And click on Save button
    Then verify the employee info

  @addingEmployee @test2
    Scenario: Adding one employee using feature file
      And user enter the "Robin" and "Biden"
      And click on Save button
      Then verify the employee info

  @addingEmployee @test3
    Scenario Outline: Adding multiple employees
    And user enter the "<firstname>" and "<lastname>" for multiple employees
    And click on Save button
    Then verify the employee info
    Examples:
      | firstname | lastname |
      |Hari       |Mathema   |
      |Naresh     |Sangroula |
      |balen      |Shah      |

  @excel
  Scenario: Adding multiple employees using excel file
    When user add multiple employees from excel using "EmployeeData" and verify it



