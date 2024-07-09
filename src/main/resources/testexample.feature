
Feature: Navigating to login page!!
  This is for regenerating framork with cucumber,
  THis for only initiate the framework.

  @tag1
  Scenario: Accessing to sign in page
    Given Go to the homepage URL
    And Click on sign-in button
    When URL matched
    Then Pass and close the browser