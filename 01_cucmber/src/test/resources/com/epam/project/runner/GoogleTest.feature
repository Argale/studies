@Test
Feature: Google Test
	
	Background: Open Google
		Given I open "http://www.google.com/webhp?hl=en"
	
	Scenario: Perform Search
		Given I don't see "Search Results Link"
		When I type "Test query" into "Search Field"
		And I click "Search Button"
		Then I see "Search Results Link"
		