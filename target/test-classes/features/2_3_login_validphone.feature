Feature: Login

Scenario: user is able to login with valid phone number

When  the user enters valid "<phone number>"
And the user clicks continue button
And the user enters the otp
Then the user validates profile created

Examples:

|phone number|
|9150786843|

