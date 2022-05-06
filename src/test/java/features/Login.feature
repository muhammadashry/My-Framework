Feature: User Login
  I want to check that the user can
  login to our website

  Scenario Outline: User Login
    Given I am in the home page and I click on sign in
    When I enter valid <e-mail> , <password>
    Then The user home page displayed successfully

    Examples:
      | e-mail                  | password    |
      | "ashrytest@hotmail.com" | "123456789" |