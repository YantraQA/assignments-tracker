
  @get
Feature: I am testing get request for Go Rest API 
  
  
   Scenario: Get request to fetch all users
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users"
    Then API should return all the users
  
   Scenario: Get request to validate pagination
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users?page=5"
    Then API should return all the users on page 5 only
      
   Scenario: Get request to fetch single user
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users/477"
    Then API should return user details of user id "477"
    
   Scenario: API should response status code as 404 for incorrect user
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users/345355353534554355"
    Then API should return user not found response for id "345355353534554355"
    
   Scenario: Get request to fetch all users with gender as female to check api resorce filter
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users?gender=female"
    Then API should return all the female users
    
  Scenario: Get request to fetch all users with gender as female and status as active to check api resorce filer
    Given Go rest API is up and running
    When I hit the api with get request and end point as "/public-api/users?gender=female&status=active"
    Then API should return all the female users with status as active
    