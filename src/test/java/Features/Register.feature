#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Title of your feature
  I want to use this template for my feature file

@tagRegister  
Scenario: sign up
Given user is on Signup page 
And user enter "<user10@user.com >" in the Email id input
And user enter "<User10>" in the Password input
And user enter "<User10>" in the Confirm Password input
And user enter a "<user10>" in the Name input
And user enter "<India>" in the Address input
And user agree enter "<Patna>" in the City input
And user click the "Signup" button
Then user should able to click on "Login to continue checking flights" button 

Examples:
| username | password | loginstatus | expPage |
| user@user.com | User | LoginPass | FlyAway.home |

