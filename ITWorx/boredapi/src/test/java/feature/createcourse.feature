Feature: Activity API

  Scenario: Check the response of the activity API
    Given that the user fires a get request
    Then the response code shall be 200
    And the response body shall be correct
