
Feature: Tekarch Rest API Testing
  

  Scenario: Login to TekarchAPI 
    Given User sets the baseURL for API request
    When User send Login API request to LoginTekarchAPI
    Then validate the response status 
    And Save the response token
    
  Scenario: the user add new UserData 
    Given User sets the baseURL for API request
    When User send post request to add new user data
    Then validate the response status 
    Then validate the successful response
    
  Scenario: the user update the existing UserData 
    Given User sets the baseURL for API request
    When User send update request to update user data
    Then validate the successful response
    
  Scenario: the user delete the existing UserData 
    Given User sets the baseURL for API request
    When User send delete request to delete the user data
    Then validate the successful response
    
   Scenario: the user get the all UserData 
    Given User sets the baseURL for API request
    When User send get request to get all the user data  
    Then validate the json schema in response
    

  
