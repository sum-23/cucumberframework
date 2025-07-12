Feature: Register user functionality

Scenario: Verify registration with mandatory fields
Given User navigates to registration page
When User enter below details
|firstName       |test                |
|lastName        |demo                |
|telephone       |1234567890          |
|password        |123456              |
|confirmPassword |123456              |
And Check privacy policy
And Click on continue button
Then User should register successfully

Scenario: Verify registration with all the fields
Given User navigates to registration page
When User enter below details
|firstName       |test                |
|lastName        |demo                |
|telephone       |1234567890          |
|password        |123456              |
|confirmPassword |123456              |
And Check subscribe yes
And Check privacy policy
And Click on continue button
Then User should register successfully

Scenario: Verify registration with already registered email
Given User navigates to registration page
When User enter below details with duplicate email
|firstName       |test                |
|lastName        |demo                |
|email           |testdemo101@demo.com|
|telephone       |1234567890          |
|password        |123456              |
|confirmPassword |123456              |
And Check privacy policy
And Click on continue button
Then Error message of email should display

Scenario: Verify registration no inputs
Given User navigates to registration page
When Don't enter any details
And Click on continue button
Then Warning message for mandatory fields should display
