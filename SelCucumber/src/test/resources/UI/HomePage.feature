@UI
Feature: Home Page Validation

	Scenario: Validate Header links
	  Given I have browser opened and url is navigated
		Then Below header Links are displayed
			|hamburger menu|
			|Serach Text Box|
			|amazon prime logo|
			|accounts and list link|
			|return and orders|
			|your prime link|
			|cart link|