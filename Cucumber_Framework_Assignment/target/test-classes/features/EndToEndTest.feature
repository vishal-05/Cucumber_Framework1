Feature: Verify end to end scenarios of the application

  Scenario: Verify Login and Logout
    Given user open website
    Then verify user is on login page
    When user login username "Admin" and password "admin123"
    Then user log out


  Scenario: Verify user can create EMP
    Given user open website
    Then verify user is on login page
    When user login username "Admin" and password "admin123"
    Then verify user is on home page
    When user click on admin button
    Then user click on add button
    When user fills new user data "k"
    Then verify success message is displayed
    When search for newly created user
    Then delete the newly created user

  Scenario: Verify user can create candidate
    Given user open website
    Then verify user is on login page
    When user login username "Admin" and password "admin123"
    Then verify user is on home page
    When user click on recruitment link
#    Then verify user is on recruitment page
#    When user click on recruitment add button
#    Then fill required details with upload on doc file in resume
    Then user enter the required details
    Then verify search result display candidate name
