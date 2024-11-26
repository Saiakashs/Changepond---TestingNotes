Feature: Login page automation of HematiteQuizApp application
 
  Scenario: Check login is successful with valid credentials
    
    Given User is on login page
    When User enters valid "<username>" and "<password>"
    And clicks on login button
    Then user is navigated to the home page
    And Close the browser
    
    Examples:
    | username | password |
    | contact@gmail.com | Admin@1234 |
    | admin@gmail.com | monica@1234 |
    | admin@gmail.com | Admin@1234 |
    