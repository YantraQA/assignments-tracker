@patch
Feature: I am testing PATCH request for Go Rest API
  
   Scenario: PATCH Request to update user in the Go Rest DB
   Given Go Rest API is up and running
   And I have a new user created in the system 
   When I hit the API with PATCH Request to update the existing user
   Then API should update the user
   And GET request to the user should return updated information 