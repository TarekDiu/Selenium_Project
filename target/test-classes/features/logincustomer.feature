
Feature: Verify Customer Login functionality
#Invalid Customerlogin Function Test
@sanity @logininvalid
Scenario Outline:  Customer Login Invalid information test  scenario
Given I am in landing page 
When I Click on Login menu
Then Enter User Id as "<userId>"          
And I Enter Password as "<password>"
And I Click on Login Button
And Verify the login error message "<error_message>"

Examples:
|userId          |password|error_message                |
|david@gmail.com | 33333  |দুঃখিত, আপনি ভুল ই-মেইল/ফোন নাম্বার/পাসওয়ার্ড দিয়েছেন!|
|kamal@gmail.com | 1234   |দুঃখিত, আপনি ভুল ই-মেইল/ফোন নাম্বার/পাসওয়ার্ড দিয়েছেন!|


#valid Customerlogin Function Test its called @Sanity Test

@sanity @login
Scenario Outline: Verify Customer Login functionality happy path
Given I am in landing page
When I Click on Login menu
Then Enter User Id as "<userId>"          
And I Enter Password as "<password>"
And I Click on Login Button
And Verify the home page

Examples:
|userId               | password  |
|tarek12345@gmail.com | Tarek746@ |





























