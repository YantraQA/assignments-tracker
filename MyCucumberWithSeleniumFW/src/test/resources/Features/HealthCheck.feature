@tag 
Feature: Health Check Script for CSCart App 1
	I will navigate the app till search
	
@tag1
	Scenario: Navigating the CSCart App till search
	Given when I open a "chrome" browser
	And I navigate to URL "http://demo.cs-cart.com/stores/9cde2d2948c74951/"
	When I enter text "computer" in search box
	And I click on submit Button 
	Then Page is navigate to search page
	