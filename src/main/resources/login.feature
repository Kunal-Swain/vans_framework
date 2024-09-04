Feature: Login with Valid Username and Password
 Checking that whatever username and password is provided that is working or not.
  
  Scenario: Checking that login process is working or not
    Given Go to the URL
    When Take screeshot of homepage
    Then click on Main Menu Content
    Then Redirect to main navigations
    Then Close the window