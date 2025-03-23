Feature: Create a new user on basketball england


  Scenario: Register a new user
    Given Navigate to registration page
    When I enter valid user info
    And  I click on submit button
    Then A new account created successfully

  Scenario Outline: Register a new user with outline
    Given Navigate to registration page
    When I enter valid details: "<firstname>", "<lastname>", "<email>", "<password>", "<confirm_password>"
    And  I click on submit button
    Then A new member account created successfully

    Examples:
      | firstname | lastname | email              | password     | confirm_password |
      | Sara      | Olson    | sara120@email.com  | Testproj110! | Testproj110!     |
      | Jenni     | Carlson  | jenni120@email.com | Testproj120! | Testproj120!     |

  Scenario: Registration fails when last name is missing
    Given Navigate to registration page
    When I enter user info without a last name
    And I click on submit button
    Then An error message for missing last name should be displayed

  Scenario: Registration fails when passwords do not match
    Given Navigate to registration page
    When I enter user info without mismatched passwords
    And I click on submit button
    Then An error message for password mismatch should be displayed

  Scenario: Registration fails when terms and conditions are not accepted
    Given Navigate to registration page
    When I enter user info without accept terms and conditions
    And I click on submit button
    Then An error message for unaccepted terms should be displayed