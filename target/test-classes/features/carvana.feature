@Carvana @Regression
Feature: Carvana CAR FINDER Functionality
  Background:
    Given user is on "https://www.carvana.com/"


  Scenario: Validate CAR FINDER menu item
    When user clicks on "CAR FINDER" menu item
    Then user should be navigated to "https://www.carvana.com/help-me-search/"
    And user should see "WHAT CAR SHOULD I GET?" text
    And user should see "Car Finder can help! Answer a few quick questions to find the right car for you." text
    And user should see "TRY CAR FINDER" link
    When user clicks on "TRY CAR FINDER" link
    Then user should be navigated to "https://www.carvana.com/help-me-search/qa"
    And user should see "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?" text
    And user should see "Select up to 4 in order of importance" text

  Scenario: Validate SELL/TRADE invalid vin search
    When user clicks on "SELL/TRADE" menu item
    Then user should be navigated to "https://www.carvana.com/sell-my-car"
    And user should see "GET A REAL OFFER IN 2 MINUTES" text
    And user should see "We pick up your car. You get paid on the spot." text
    When user clicks on "VIN" button
    And user enters vin number as "00000000000000000"
    And user clicks on "GET MY OFFER" button
    Then User should see "We couldn’t find that VIN. Please check your entry and try again." text

  Scenario: Validate AUTO LOAN CALCULATOR under FINANCING menu item
    When user hovers over on "FINANCING" menu item
    And User clicks on "AUTO LOAN CALCULATOR" menu item
    When user clicks on "Cost of Car I want" and enters "10,000"
    And user clicks on "What's Your Credit Score?" and selects "Excellent: 780"
    And user clicks on "Choose Your Loan Term" and select "60 Months"
    And user clicks on "What is Your Down Payment?" and enters "1,500"
    Then user should see the monthly payment as "154.00"








