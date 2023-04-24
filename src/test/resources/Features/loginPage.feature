@login
Feature: Validate login feature

  Background:
    Given User is in Home Page
    When User clicks on SignIN Link
    Then User is navigated to SignIN Page

  @ValidLoginScenario
  Scenario: Validate valid login scenario
    Given user enters correct un and pwd
    When clicks on login button
    Then User is in Home Page

  @signINBTNEnabled/DisabledScenario
  Scenario Outline: Verify signIN Button Enabled|Disabled
    When user enters "<userName>" "<password>"
    Then signIN Button should be disabled

    Examples:
      | userName | password |
      |          |          |
      |          | test@123 |
      | testTom  |          |

  @inValidLoginScenario
  Scenario Outline: verify login with invalid credentials
    When user enters "<userName>" "<password>"
    When clicks on login button
    Then validation Error should be Displayed as per "<scenarioName>"
    Examples:
      | scenarioName                      | userName    | password |
      | inValidUserName & inValidPassword | sds         | sds      |
      | validUserName & inValidPassword   | kbtestUser1 | sds      |
      | invalidUserName & ValidPassword   | sds         | test@123 |