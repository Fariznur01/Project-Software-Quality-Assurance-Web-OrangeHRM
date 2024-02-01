Feature: Functionality Tab Profile
  In order to know profile rab,
  I want to explore the profile tab.

  @Regression @Positive
  Scenario: TabProfile 1
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    When I click tab profile
    And I click about
    Then I should see about system web
    And I click button back
    When I click tab profile
    And I click support web
    Then I should see about support web
    When I click tab profile
    And I click change password
    Then I should see page change password
    When I enter valid currentpassword "admin123", password "test01@@" and password confirm "test01@@"
    And I click the save button
    When I click tab profile
    And I click the logout button
    Then I should be logged out

  @Regression @Negative
  Scenario: TabProfile 2
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully
    When I click tab profile
    And I click change password
    Then I should see page change password
    When I enter valid currentpassword "admin123",but valid password "test01@@" and  invalid password confirm "test11@@"
    And I click the save button
    Then I should see fail save new password