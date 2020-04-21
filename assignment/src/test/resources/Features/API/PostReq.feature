
@Post
Feature: I am testing post request for Go Rest API

 Scenario: Post req to create a user in the Go Rest DB
    Given Go rest API is up and running
    And I set Header and Body to create new user
    When I hit the api with post request and end point as "/public-api/users"
    Then API created a new User in the system
    #And I can find the new user in the system when i get the user

Scenario: Post req to validate error msg when no body is sent
    Given Go rest API is up and running
    And I set Header and pass empty body
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the code as 422
    And displayed error messages
    
Scenario: Post req to validate error msg when empty field values are sent
    Given Go rest API is up and running
    And I set Header and Body with empty fields
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the code as 422
    And displayed error messages    
    
Scenario: Post req to validate error msg when incorrect email and gender is sent in the body
    Given Go rest API is up and running
    And I set Header and Body with incorrect email and gender
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the code as 422
    And displayed the error msg as "Email is not a valid email address."
    And displayed the error msg as "Gender is invalid."
    
    
Scenario: Post req to validate error msg when incorrect datatypes for all the fields are sent
    Given Go rest API is up and running
    And I set Header and Body with all fields incorrect
    When I hit the api with post request and end point as "/public-api/users"
    Then API returned the code as 422 
    And displayed invalid datatype msgs
         