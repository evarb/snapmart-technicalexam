Feature: Snapmart Inc End2End Test
Description: User orders an item from the website and proceeds to checkout.

Scenario: Login on OWASP Juice Shop and checkout an item

Given user is on Login page
Then input credentials to login page
And user search for "banana juice" 
And add to basket the first item
Then checkout item from mini cart
Then select an address and "5 Days" delivery
And select payment card
And place order and pay
