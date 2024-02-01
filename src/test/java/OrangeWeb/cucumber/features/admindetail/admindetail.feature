Feature: Functionality Detail Profile
  In order to know profile rab,
  I want to explore the profile tab.

  @Regression @Positive
  Scenario: Admin User Management
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    And I click admin via sidebar
    Then I should in admin page
    #When I enter system user with valid username "Admin", select user role as "Admin" from the dropdown, valid employee name as "Paul Collings", and select status as "enable" from the dropdown
    When I enter system user with valid username "Admin"
    And I click search button
    Then I should see a record
   #When I refresh admin page
   #And I click button data admin
   #Then I check box password

  @Regression @Positive
  Scenario: Admin Job
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    And I click admin via sidebar
    Then I should in admin page
    And I click bar menu Job
    Then I choose job titles from several options
    And I should in job page
    Then I choose button add job
    And I should in page add job
    #When I enter valid job title "Ux Design Test", valid job description "Ux Design Test", valid file  and valid note "Ux Design Test"
    When I enter valid job title "Ux Design Test", valid job description "Ux Design Test"  and valid note "Ux Design Test"
    And I click save button

  @Regression @Negative
  Scenario: User Management
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    And I click admin via sidebar
    Then I should in admin page
    #When I enter system user with valid username "Admin", select user role as "Admin" from the dropdown, valid employee name as "Paul Collings", and select status as "enable" from the dropdown
    When I enter system user with invalid username "Admin123"
    And I click search button
    Then I should see no record
