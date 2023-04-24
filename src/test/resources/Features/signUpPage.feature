@signUp
Feature: signUp Feature

  Background:
    Given User is in Home Page
    When User clicks on SignUP Link

  @validUserNameEmail
  Scenario: new User Sign Up
    Then User enters signUp Details
    And Verifies if user is logged into the system

  @invalidUserNameEmail
  Scenario Outline: signUp with invalid userName | Email
    Then User enters invalid "<userName>" "<Email>" and correct "<Password>"
    And Verifies if validation error is displayed
    Examples:
      | userName | Email  | Password |
      | k.bhatt  | kbhatt | test@123 |

  @duplicateUserNameEmail
  Scenario Outline: signingUp with existing userID in System
    Then User enters invalid "<userName>" "<Email>" and correct "<Password>"
    And Verifies if validation Error is displayed for existing userName and email
    Examples:
      | userName | Email            | Password |
      | krunal1  | krunal1@test.com | test@123 |