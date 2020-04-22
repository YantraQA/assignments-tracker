@put
Feature: I am testing POST request for Go Rest API
  
   Scenario: PUT Request to update user in the Go Rest DB
   Given Go Rest API is up and running
   And I have a new user created in the system 
   When I hit the API with PUT Request to update the existing user details 
   Then API should update the user
   And GET request to the user should return updated information
   
   Scenario: PUT Request, validationn message is received when wrong gender and email is sent
   Given Go Rest API is up and running
   And I have a new user created in the system 
   When I hit the API with PUT Request and setting wrong email and gender 
   Then API returned the error code as 422
   And error message displayed as "Email is not a valid email addresss."
   And error message displayed as "Gender is invalid"
   
   Scenario: PUT Request to update in-correct user then validation message is thrown
   Given Go Rest API is up and running
   And I have a new user created in the system 
   When I hit the API with PUT Request to update incorrect user 
   Then API returned the error code as 422
   And error message displayed as "Object not found."  