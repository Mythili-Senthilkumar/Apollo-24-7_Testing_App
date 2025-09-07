Feature: Login

Scenario: user is able to login with valid phone number

Given the user is on main page
When the user clicks on login button
And the user enters valid "<phone number>"
And the user clicks continue button
And the user enters the otp
Then the user validates profile created

Examples:

|phone number|
|9150786843|
