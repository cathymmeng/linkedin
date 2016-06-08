Feature: Cucumber and Geb

As an Agile automation QA
I use Cucumber and Geb to interact with Linkedin
So I can demonstrate my sweet automation skills

  Scenario: Linked in login > HomePage
    Given I am on the "Login" page
    When I enter ID and password
    Then I am taken to the "Home" page