@homePage
Feature: Validating Home Page

  Scenario: Checking Home Page functionality
    Given User is in Home Page
    When User clicks on SignIN Link
    Then User is navigated to SignIN Page