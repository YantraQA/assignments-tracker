@tag
Feature: I am testing Page of amazon website
  @tag1
  Scenario: Search for Product
    Given open the Browser and nevigated to url
    When I enter product "Dell"
    Then product get appear "Dell"
  @tag2
  Scenario: SignIn into amazon account
    Given open the Browser and send url
    When I over on signBlock & I Click on sign In
    And  I Enter email and click on continue
    Then I also Enter Password then on signin
 