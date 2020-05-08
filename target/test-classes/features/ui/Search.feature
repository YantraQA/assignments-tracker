@ui @search
Feature: Search functionality
   
  Scenario: Search a product
    Given I have browser opened and url is navigated
    When I searched for products as "Dell"
    Then Product list should appear pertaining to the product searched as "Dell"
     