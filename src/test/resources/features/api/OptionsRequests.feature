@options
Feature: I am testing OPTIONS request for Go Rest API
  
   Scenario: OPTIONS Request to update user in the Go Rest DB
   Given Go Rest API is up and running
   When I hit the API with OPTIONS Request 
   Then API should return the list of available methods
    