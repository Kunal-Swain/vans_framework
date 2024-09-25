Feature: Check that menu and main navigation is working or not!
  Here need to check that all main menu links are clickable or not click on.
  Shopping Cart, Favorite, Sign In, Find a Store, Help
  Along with all main catagories.
  
  Scenario: Navigation Links are working or not
    Given Go to the URL
    When Take screeshot of homepage
    Then click on Main Menu Content
    When Redirect to main navigations
    Then Click on each New Arrival Link
    Then Close the window
    