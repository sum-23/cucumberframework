Feature: Login functionality

Scenario: Login with valid credentials
Given User has navigated to login page
When User enters valid email ""
And User enters valid password ""
And Click on login button
Then User should login successfully

Scenario: Login with valid credentials
Given User has navigated to login page
And User enters invalid email ""
And User enter invalid password ""
Then Invalid credentials waring message should display

Scenario: Login with valid email and invalid password
Given User has navigated to login page
When User enters valid email ""
And User enter invalid password ""
And Click on login button
Then Invalid credentials waring message should display
 
Scenario: Login with invalid email and valid password
Given User has navigated to login page
When User enters invalid email ""
And User enters valid password ""
And Click on login button
Then Invalid credentials waring message should display

Scenario: Login with no credentials
Given User has navigated to login page
When Don't enter any email
And Don't enter any password
And Click on login button
Then Invalid credentials waring message should display
