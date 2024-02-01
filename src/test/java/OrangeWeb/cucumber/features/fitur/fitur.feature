Feature: Functionality Features

  To explore the application's functionalities,
  I want to be able to access different features after logging in.


  @Regression @Positive
  Scenario: View Admin Feature 1
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    When I click button list menu
    And I click admin menu
    Then I should see a list of employees with Admin role
    And I click PIM menu
    Then I should see a list of employees under PIM
    And I click leave menu
    Then I should see a list of employees whose leave
    And I click time menu
    Then I should see a list of timesheets pending action
    And I click recruitment menu
    Then I should see a list of candidates
    And I click profile menu
    Then I should see my profile
    And I click performance menu
    Then I should see a list of performance
    And I click dashboard menu
    Then I should see a dashboard
    And I click maintance menu
    When  I enter valid password "admin123"
    And I click the confirm button
    Then I should be logged admin in successfully
    And I click claim menu
    Then I should see a list of claim employees
    And I click Buzz menu
    Then I should see a Buzz Newsfeed

  @Regression @Negative
  Scenario: View Admin Feature 2
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    And I click maintance menu
    When  I enter invalid password "admin1234"
    And I click the confirm button
    Then I should see an error message