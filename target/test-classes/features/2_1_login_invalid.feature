Feature: Login with Invalid Credentials

Scenario Outline: User cannot login with invalid phone numbers
  Given the user is on main page
  When the user clicks on login button
  And the user enters invalid "<phone number>"
  Then the continue button should be disabled

Examples:
  | phone number |
  | 13456        |
  | 999          |

Scenario: User is unable to login with invalid OTP
  Given valid number is entered as "<phone number>"
  When the user clicks continue button and enters an invalid OTP
  Then the user sees a validation error

Examples:
  | phone number |
  | 9150786843   |
