  @ui
Feature: Laptop Search in amazon with Findelements

  Scenario: By findelements search
    Given I open browser
    When Send key "Dell"
    Then I get List of "Dell"
  