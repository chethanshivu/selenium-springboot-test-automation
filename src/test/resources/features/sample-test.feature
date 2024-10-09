@Regression
  Feature: Sample tests

    @SelectedTests
    Scenario: Login to the UI

      Given User launch the web application with url "https://www.orangehrm.com"
      When User enters the Username ""
      And User enters the Password ""
      And User clicked on Login
      Then Home page should be open