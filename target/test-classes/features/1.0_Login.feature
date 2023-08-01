Feature: Contacts App
  Scenario: Scenario Find Detail Selected Contact from Various Contact List 
  	Given Go to Contacts App
  	When Click search button
  	Then input contact name <Name> in search contact button
  	When click contact that want to be selected one of the research results
  	Then Directing to Next Page Detail Selected Contact Information
  	
  	
  	Examples: 
      |Name|
      |irsyad GW|