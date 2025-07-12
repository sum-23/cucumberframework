Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email <email>
And User enters valid password <password>
And Click on login button
Then User should login successfully
Examples:
|email               |password|
|demotest103@demo.com|123456  |
|demotest103@demo.com|123456  |
|demotest103@demo.com|123456  |

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email
And User enters invalid password "654321"
And Click on login button
Then Invalid credentials warning message should display

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email "demotest103@demo.com"
And User enters invalid password "654321"
And Click on login button
Then Invalid credentials warning message should display
 
Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email
And User enters valid password "123456"
And Click on login button
Then Invalid credentials warning message should display

Scenario: Login with no credentials
Given User navigates to login page
When Don't enter any credentials
And Click on login button
Then Invalid credentials warning message should display
