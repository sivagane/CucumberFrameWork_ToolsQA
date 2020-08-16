Feature: Automation Practice Site

  Scenario Outline: User is Buying a Book
    Given User Navigates to Homepage
    When User Searches and Selects the Book
    And User Adds the Book to Cart and Clicks Checkout button
    And User enters "<customer>" the Personal Details
    And User selects Payment Method and Clicks the Place Order button

    Examples: 
      | customer |
      | Siva     |
