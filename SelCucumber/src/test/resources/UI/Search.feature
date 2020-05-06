@tag
Feature: Search Functionality
 

  @tag1
  Scenario: Search the product
    Given I have browser open and url is navigated
    When I search product as "Dell"
    Then Product list should appear to the product seerch as "Dell"
    

 