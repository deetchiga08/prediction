Feature: Create general

  Scenario: WITH ALL REQUIRED FIELDS IS SUCCESSFUL

    Given user wants to create an general with the following attributes
      | id | name   |
      | 1  | Rachel |

    When user saves the new general 'WITH ALL REQUIRED FIELDS'
    Then the save 'IS SUCCESSFUL'