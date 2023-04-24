@articleCRUDOperationCheck
Feature: validating article create|Update|Delete operations

  Background:
    Given User is in Home Page
    When User clicks on SignIN Link
    Then User is navigated to SignIN Page
    Then user enters correct un and pwd
    And clicks on login button

  @newArticleCreate
  Scenario: Verifying if new Article is created successfully

    Given User is in Home Page
    When User clicks on newArticle link
    Then User enters Article Details
    And Verifies if data entered is correctly saved

  @editArticle
  Scenario Outline: Verifying edit Article Functionality
    Given User is in Home Page
    When User clicks on newArticle link
    Then User enters Article Details
    And Verifies if data entered is correctly saved
    Then User clicks on editArticle Link
    And User updates Article Details "<articleTitle>" "<aboutArticle>" "<articleDescription>" "<tags>"
    And Verifies if data entered is correctly saved

    Examples:
      | articleTitle      | aboutArticle    | articleDescription | tags          |
      | articleUpdateTest | toUpdateArticle | howToUpdateArticle | updateArticle |

#  @deleteArticle
#    @pendingToCode
#  Scenario Outline: Verifying delete Article Functionality
#    Given User is in Home Page
#    Then User fetches data
#    When User clicks on newArticle link
#    And User enters Article Details
#    Examples:
#      | articleTitle      | aboutArticle    | articleDescription | tags          |
#      | articleUpdateTest | toUpdateArticle | howToUpdateArticle | updateArticle |