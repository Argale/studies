@Test
Feature: Google test outline
 
        Scenario Outline: Verify titles
                When I open "<url>"
                Then the page title must be "<page title>"
                
		Examples:
         |               url                    |      page title       |  
                                   
         | http://www.google.com/webhp?hl=en    |        Google         |
         | http://www.bing.com                  |         Bing          |
         | http://www.wikipedia.org             |       Wikipedia       |