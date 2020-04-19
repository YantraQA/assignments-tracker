@options
Feature: I am testing option request Go Rest API

Scenario: Option request to check available request
 
 Given Go Rest API up and running
 When I hit the API with option request
 Then API should return the list of available methods
 