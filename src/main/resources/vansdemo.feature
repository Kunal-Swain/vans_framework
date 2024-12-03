Feature: Deno for checking VANS Image download process
  I want to use this template for my feature file

  Scenario: Go to the vans url and download image
    Given go to the url of vans s3
    And login with valid username and password
    When go to catalogs
    And click on first product
    And click on download button
    Then click on standard download