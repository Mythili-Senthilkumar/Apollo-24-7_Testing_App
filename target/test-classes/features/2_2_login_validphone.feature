Feature: Successful Login

Scenario: User can login successfully with valid phone number

Given   the user enters valid "<phone number>"
When  the user clicks continue button
And the user enters the correct OTP
Then the user should see that the profile created

Examples:

|phone number|
|9150786843|

