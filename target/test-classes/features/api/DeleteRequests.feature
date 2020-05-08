@api @delete
Feature: I am testing DELETE request for Go Rest API
  
   Scenario: DELETE Request to update user in the Go Rest DB
   Given Go Rest API is up and running
   And I have a new user created in the system 
   When I hit the API with DELETE Request  
   Then API should delete the user
   And GET request to the user should not return the user 