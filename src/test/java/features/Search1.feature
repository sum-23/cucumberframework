Feature: Search products functionality

Scenario: User Search with valid product
Given User navigate to search page
When User enter valid product name "imac"
And Click on search button
Then Valid product should display

Scenario: User Search with invalid product
Given User navigate to search page
When User enter invalid product name "tesla"
And Click on search button
Then User should get a message no product matching

Scenario: User Search with no product
Given User navigate to search page
When User doesn't enter any product name
And Click on search button
Then User should get a message no product matching

