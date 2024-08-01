Feature: Navigating to login page!!
  This is for regenerating framork with cucumber,
  THis for only initiate the framework.

  Scenario: Accessing to sign in page.
    Given Go to the homepage URL
    And Click on sign-in button
    When URL matched

  Scenario: Click on Create an Account and verify.
    Given Verify Page

  Scenario: Click on Create an Account and verify.
    Given Fill all mandatory fields
    And Fill other fields
    When Check checkbox optional
    Then Click on create account