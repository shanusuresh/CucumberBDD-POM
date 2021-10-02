Feature: Contact Us page
  Background:
    Given user has already logged in to application
      |username|password|
      |priya.learndevelopment@gmail.com|automation123|
    And user is on Accounts page

    Scenario: Contact us page title
      Given user is on Contact us page
      When user gets the title of the page
      Then page title should be "Contact us - My Store"

      Scenario: Contact us page elements
        Given user is on Contact us page
        When user sends a message
        |SubjectHeading| Emailaddress | Message|
        |Customer service|priya.learndevelopment@gmail.com|test1|
        And clicks on Send button
        Then message "Your message has been successfully sent to our team." should be sent successfully
