Feature: Parameter Examples

Background: Before Every Scenario
Given Execute BackGround

 

  @WithoutParamKeyword @smoke 
  Scenario: User Able to Login into the application
    Given Launch the Application
    When Enter the "mercury" as UserName
    And Enter the "mercury" as Password
    And Click on SignOn
    Then Verify the Home Page
    
    
    
   @ParameterWithKeyword @smoke
  Scenario Outline: User Able to Login into the application
    Given Launch the Application
    When Enter the "<username>" as UserName
    And Enter the "<password>" as Password
    And Click on SignOn
    Then Verify the Home Page
    Examples:
    |username|password|
    |mercury|mercury|
    |mercury|mercury|
    |mercury|mercury|
    
     @dtTable
  Scenario: User Able to Login into the application
    Given Launch the Application
    When Enter the UserCredentials from dttable
    |username|password|
    |mercury|mercury|
    And Click on SignOn
    Then Verify the Home Page    
    