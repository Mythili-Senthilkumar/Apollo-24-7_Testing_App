Feature: Login

Scenario: user is unable to login with invalid OTP

When  the user enters valid "<phone number>"
And the user clicks continue button
Then the user enters and validates wrong otp

Examples:

|phone number|
|9150786843|

