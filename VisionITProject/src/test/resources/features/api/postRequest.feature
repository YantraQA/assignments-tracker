@post
Feature: I am testing post Request for Go Rest API
 @sanity
  Scenario: post request to create a User in the Go Rest DB
    Given Go Rest API up and running
    And I set header and body is create new user
    When I hit the API with post request and end point as "/public-api/users"
    Then API created new user in the system
    And I can find new user in the system when i get the user
    
  Scenario: post request validate error message when no body is sent 
    Given Go Rest API up and running
    And I set header and without any body
    When I hit the API with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message display as "Email cannot be blank."
    And error message display as "First Name cannot be blank."
    And error message display as "Last Name cannot be blank."
    And error message display as "Gender cannot be blank."
    
  Scenario: post request validate error message when empty field values are sent in body
    Given Go Rest API up and running
    And I set header and with fields but no values
    When I hit the API with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message display as "Email cannot be blank."
    And error message display as "First Name cannot be blank."
    And error message display as "Last Name cannot be blank."
    And error message display as "Gender cannot be blank."
    
  Scenario: post request validate error message when incorrect email and gender is sent in body
    Given Go Rest API up and running
    And I set header and with incorrect email and gender
    When I hit the API with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message display as "Email is not a valid email address."
    And error message display as "Gender is invalid."
    
  Scenario: post request validate error message when incorrect data types for all fields are sent
    Given Go Rest API up and running
    And I set header and body with incorrect data types are sent for every mandatory field
    When I hit the API with post request and end point as "/public-api/users"
    Then API returned the error code as 422
    And error message display as "Gender must be a string."
    And error message display as "Email is not a valid email address."
    And error message display as "First Name must be a string."
    And error message display as "Last Name must be a string."
    
    
    