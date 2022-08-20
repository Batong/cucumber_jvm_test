Feature: Open webapp

  As a test developer
  I want to be able to write a specflow test
  So that I can check that the web app does launch properly

  @webapp
  Scenario: Webapp loads correctly
    Given I browse to the main site
    Then the correct week should be displayed

  @webapp
  Scenario: WebAPI launches successfully
    Given I add the "https://api.publicapis.org" URL with endpoint "/entries"
    When I execute the request
    Then the correct "200" response is returned