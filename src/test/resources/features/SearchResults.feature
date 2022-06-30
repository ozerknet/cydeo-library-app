Feature: As a user, I should be able to login as librarian. When I go to Users
  page, table
  should have following columns:
  • Actions
  • UserID
  • Full Name
  • Email
  • Group
  • Status

  Background: Assuming user is on the login page
    Given user is on the login page

  Scenario: Table columns names
    When user enters librarian username and password
    Then user should see the dashboard
    And I click on users link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |