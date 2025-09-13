Feature: Payment 

Scenario: User can able to proceed payment
Given the user clicks proceed
When the user clicks add plan
And the user validates benefits applied in cart section
And the user clicks proceed button for payment and validates delivery type
And the user clicks proceed in delivery type and validates payment page
And the user clicks on show QR code
Then the user clicks on cancel for canceling payment