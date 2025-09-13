Feature: Payment invalid

Scenario:  User unable to proceed with payment via pay later
Given the user clicks on procced in cart section
When the user selects skip savings
And the user clicks on proceed for payment
And the user again clicks procced in delivery section
And the user verifies the payment page with multiple payment options
Then the user validates that pay later option is not clicable






