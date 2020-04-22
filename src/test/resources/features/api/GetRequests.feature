@get
Feature: I am testing GET request for Go Rest API
  
   Scenario: Get Request API to fetch all users
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users"
    Then API should return all the users
 
    Scenario: Get Request to validate pagination
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users?page=5"
    Then API should return all the users on page 5 only
    
    Scenario: Get Request fetch single user details
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users/449"
    Then API should return user details of user id "449"
    
    Scenario: API should get response status code as 404 for incorrect userr
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users/764674723"
    Then API should return user not found response for id "764674723"
    
    Scenario: Get Request fetch all users with gender as female to check api resource filter
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users?gender=female"
    Then API should return all female users
    
    Scenario: Get Request fetch all users with gender as female and status as active to check api resource filter
    Given Go Rest API is up and running
    When I hit the API with GET Request and end point as "/public-api/users?gender=female&status=active"
    Then API should return all users with gender as female and status as active
    
    