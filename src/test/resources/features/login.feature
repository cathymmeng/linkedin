Feature: Cucumber and Geb

As an automation tester
I would like to use Cucumber and Geb together
So I can have a sweet automation stack

  Scenario: Linked in login > HomePage
    Given I am on the "Login" page
    When I enter ID and password
    Then I am taken to the "Home" page

    @wip
  Scenario: Visit another page (that has no been automated yet hense the @wip)
    Given I am on the "Geb Home" page
    When the link to another page
    Then I am taken to the other page