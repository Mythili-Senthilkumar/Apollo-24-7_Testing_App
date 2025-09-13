Feature: Invalid address management

Scenario: User enters invalid text for searching area

Given user clicks on change 
When user validates that the new sidebar opens 
And user clicks on add button
Then user types the address and validates that no results found

Scenario: User unable to save flat number

Given user clicks add address in change 
When user enter single character flat number
Then user validates that minimum two characters required


Scenario: User unable to save address as part
Given user is on enter address details page
Then  user cannot select any option it shows an information that select any one

#defect
Scenario: User can able to enter invalid credentials to save address
Given user is on address details page
When  user enter invalid name in the textfield 
Then user can save the address

