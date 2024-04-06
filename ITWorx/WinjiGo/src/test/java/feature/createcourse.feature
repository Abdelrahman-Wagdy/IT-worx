Feature: Create a new course
  Background:
    Given User navigates to the website

  Scenario: Create a new course and check that it is added to the courses list
    Given that the user logs in
    And the user navigates to the courses page
    Then the user clicks on add course button
    Then the user fills all the form data
    When the user click on the create button
    And the user navigates to the courses page
    Then the course should reflect on the courses list page
