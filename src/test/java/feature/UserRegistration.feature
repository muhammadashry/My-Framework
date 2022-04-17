Feature: User registration
  I want to check the user can register in our Website

  Scenario Outline: User Registraion
    Given The user in the home page
    When I click on Sighin link
    And I enter my "<email>"
    And click On Create an account
    Then I should go to the registration form

    Examples:
      | email |
    | fasdfadsfas@hoymail.com|