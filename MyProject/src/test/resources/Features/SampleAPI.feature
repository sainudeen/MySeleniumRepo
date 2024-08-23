Feature: Sample API Test

Background: User Generate Token for authorization
Given I am an authorized user

@API
Scenario: Authorize User able to Add and Remove a book
Given A list of books are available
When I add a book to my reading list
Then The book is added
When I remove a book from my reading list
Then The book is removed