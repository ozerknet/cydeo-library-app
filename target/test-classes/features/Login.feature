Feature:Library app login feature
  User Story:
  As a user, I should be able to login with correct
  credentials to different accounts

  Background: Assuming user is on the login page
    Given user is on the login page

  @librarian @employee
  Scenario: Login as librarian
    When user enters librarian username and password
    Then user should see the dashboard


  @student
  Scenario: Login as student
    When user enters student username and pasword
    Then user should see the dashboard