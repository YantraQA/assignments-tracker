@post
Feature: I am testing POST request for Go Rest API
  
   Scenario: Post Request to create a user in the Go Rest DB
   Given Go Rest API is up and running
   And I set header and Body to create new user 
   When I hit the API with POST Request and end point as "/public-api/users"
   Then API created a new USER in the system
   And I can find the new user in the system when i get the user  
   
   