Feature: CanaryApi
  As an Automation Framework user
  I want to be able to make a sample Get Api call
  So that I can confirm it is working

  @Canary
  Scenario: Sample Get
    Given I call Canary Test API
    When I get a response message of: 'HTTP/1.1 200 OK'
    Then I expect a status code of: 200

  @Canary
  Scenario: Failed Test
    Given I call Canary Test API
    When I get a response message of: 'HTTP/1.1 200 OK'
    Then I expect a status code of: 300