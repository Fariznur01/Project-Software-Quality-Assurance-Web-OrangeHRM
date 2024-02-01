Feature: Login Functionality

  In order to access the application,
  I want to be able to log in to the website.

  @Regression @Positive
  Scenario: Successful Login
    Given I am on the login page
    When I enter valid username "Admin" and password "admin123"
    And I click the login button
    Then I should be logged in successfully

  @Regression @Negative
  Scenario: Failed Login with Invalid Password and Valid Username
    Given I am on the login page
    When I enter a valid username "Admin" and an invalid password "invalid_password"
    And I click the login button
    Then I should see an error message

  @Regression @Negative
  Scenario: Failed Login with Invalid Username and Valid Password
    Given I am on the login page
    When I enter an invalid username "InvalidUser" and a valid password "admin123"
    And I click the login button
    Then I should see an error message

  @Regression @Positive
  Scenario: User requests password reset link
    Given I am on the login page
    When I click on the "Forgot Password" link
    And I enter my username "Admin"
    And I click the reset password button
    Then I should see a message that a password reset link has been sent to my email

  @Regression @Negative
  Scenario: User requests password reset link for an unregistered user
    Given I am on the login page
    When I click on the "Forgot Password" link
    And I enter my username "User01"
    And I click the reset password button
    Then I should see a message that the username is not registered


