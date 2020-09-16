Feature: Snapmart Inc End2End Test
Description: User orders an item from the website and proceeds to checkout.

@end2endPass
Scenario: Login on OWASP Juice Shop and checkout a valid item

Given user is on Login page
Then input credentials to login page
And user search for "Green Smoothie" 
And add to basket the first item
Then go to mini cart
Then checkout item from basket
Then select an address 
Then select "5 Days" delivery
And select payment card
And place order and pay

@end2endFail
Scenario: Login on OWASP Juice Shop and checkout an invalid item

Given user is on Login page
Then input credentials to login page
And user search for "InvalidItem" 
And add to basket the first item
Then go to mini cart
Then checkout item from basket
Then select an address 
Then select "5 Days" delivery
And select payment card
And place order and pay
