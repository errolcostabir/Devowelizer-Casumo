Feature: To check the response of the get request

  Scenario Outline: Check if there is a vowel in the response
    Given get request is made to the respective URI
    And the words checked are "<words>"
    Then the response body should not have a vowel
    Examples:
      | words   |
      | errol   |
      | input   |
      | gherkin |
      | Malta   |
