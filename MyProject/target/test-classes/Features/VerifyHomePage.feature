Feature: Verify Home Page Feature

  @DataProvider1
  Scenario: User Able to Login into the application
  	META-DATA:  {"dataProvider":"my-custom-dp", "dataProviderClass":"seleniumbasic.ReadExcelFile","description":"Data driven test that uses custom data provider"}
    Given Launch the Application
    When Enter the '${username}' as UserName
    And Enter the '${password}' as Password
    And Click on SignOn
    Then Verify the Home Page
