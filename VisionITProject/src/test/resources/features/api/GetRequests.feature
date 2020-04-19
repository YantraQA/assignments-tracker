@get
Feature: I am testing Get Request for Go Rest API
 @sanity
  Scenario: Get request to Fetch all Users
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users"
    Then API should return all the users

  Scenario: Get request to Validate Pagination
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users?page=5"
    Then API should return all the users on page 5 only
    
  Scenario: Get request to Fetch Single User
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users/645"
    Then API should return user details of user id "645"
    
    Scenario: API should get response status code as 404 for incorrect user 
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users/345355353534554355"
    Then API should return user not found response for id "345355353534554355"
    
    Scenario: Get request to fetch all users with gender as female to check api resource filter 
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users?gender=female"
    Then API should return all female users
    
    Scenario: Get request to fetch all users with gender as female and status as active
    Given Go Rest API up and running
    When I hit the API with Get request and end point as "/public-api/users?gender=female&status=active"
    Then API should return all female users with status as active
    
    