Feature: Login

Scenario Outline:
user unable to login with invalid phone number

Given the user is on main page
When the user clicks on login button
When the user enters invalid "<phone number>"
Then user validates that continue button disabled

Example:

|phone number|
|13456|