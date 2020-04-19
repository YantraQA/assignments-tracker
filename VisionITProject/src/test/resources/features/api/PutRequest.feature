@put

Feature: I am Testing put request for go rest API

  Scenario: Put request to update use in Go Rest DB
   Given Go Rest API up and running
   And I have a new user created in the system
   When I hit the api with put request to update the existing user details 
   Then API should update the user 
   And get request to the user should return updated information
   
  Scenario: Put request, validation message is received when wrong gender and email is sent
   Given Go Rest API up and running
   And I have a new user created in the system
   When I hit the api with put request and setting wrong email
   Then API returned the error code as 422
   And error message display as "Email is not a valid email address."
  
  
  Scenario: Put request to update in-correct user then validation message is thrown
   Given Go Rest API up and running
   And I have a new user created in the system
   When I hit the api with put request to update the incorrect user
   Then API returned the error code as 404
   And error message display as "Object not found:"
 