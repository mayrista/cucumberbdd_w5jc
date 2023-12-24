Feature: Admin Login
  #1
  Scenario: Admin Login Valid
    Given Admin enter url web Sauce demo
    When Admin enter username and password
    And Admin click login button
    Then Admin login successful redirect page dasboard

  #2
  Scenario: Admin Login Required Login
    Given Admin enter url web Sauce demo or logout
    When  Admin enter null username and password
    And Admin click login button
    Then Admin required login
