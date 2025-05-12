Feature: Verify Customer Login functionality using ExelFile

@Sanity @excelfile

Scenario Outline: Verify Customerlogin using my Exelfile data
Given I am in website homepage
When I clicked the সাইন ইন Button
Then I Put it my Email in Email field "<rownumber>" 
Then I Put it my  Password in Password field
Then I click the সাবমিট Button 
Then I log in my profile successfully error 

Examples: 
|rownumber|
|0        |
|1        |
       