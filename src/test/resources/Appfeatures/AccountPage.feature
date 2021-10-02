Feature: Account page feature

  Background:
    Given user has already logged in to application
    |username|password|
    |priya.learndevelopment@gmail.com|automation123|

    Scenario: Accounts page title
      Given user is on Accounts page
      When user gets the title of the page
      Then page title should be "My account - My Store"

      Scenario: Accounts section
        Given user is on Accounts page
        Then user gets account section
        |ORDER HISTORY AND DETAILS|
        |MY CREDIT SLIPS|
        |MY ADDRESSES|
        |MY PERSONAL INFORMATION|
        |MY WISHLISTS|
        And accounts section count should be 5

        Scenario: Top menu validation
          Given user is on Accounts page
          Then user sees the top menu
          |WOMEN|
          |DRESSES|
          |T-SHIRTS|
          And the top menu count should be 3