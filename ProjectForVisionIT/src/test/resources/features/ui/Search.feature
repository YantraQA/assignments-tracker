@tag
Feature: Search functionality
  
  @tag1
  Scenario: Search a product
    Given I have browser open and url is navigated
    When I search for product as "Dell"
    Then Product list should appear pertaining to the product search as "Dell"
    
 
 