
@tag
Feature: Search fuctionality
  I want to use this template for my feature file

  Scenario: Search a product 
    Given I have browser opened and url is nevigated 
    When I Search for product as "Dell"
    Then product list should appear pertaining to the product search as "Dell"
    
