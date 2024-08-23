Feature: Read the data from external file system and transform it

  Scenario: Convert the data table to the user define type
    Given The excel file name and location is given as
      | Excel             | Location                        | Sheet | Index |
      | MockTestData.xlsx | D:\\TestData\\MockTestData.xlsx | data  |     3 |
    Then Verify Second Row
