Feature: Perform UAT for currency converter

Background: 
 		Given Open web browser  
    When Navigates to the specified url
    Then Homepage loads 
  
Scenario Outline: Convert INR to EURO for multiple values
    Given User selects currency converter menu from navigation panel
    When User enters amount "<amount>"
    And User select currency From dropdownlist 
    And User select currency to dropdownlist
    And User clicks on convert button 
    Then Result is displayed and validated

    Examples: 
      | amount|
      | 100 |    
      | 200 |   
      | 300 |
      | 400 |
      | 500 |
