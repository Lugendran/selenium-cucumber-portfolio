Feature: Invalid Login

  Scenario: Login with wrong password
    Given I am on the login page
    When I enter username "standard_user" and wrong password "wrongpass"
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"