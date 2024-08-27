Feature: Search the product and place the order

  @SearchProduct
  Scenario Outline: Serach for the product on both home page and Offers page
    Given User is on GreenCart landing page
    When User searched with shortname <Name> and extracted actual product
    Then user searched for same shortname <Name> in offers page
    And Validate veg name on homepage and offer page
Examples:
    | Name |
    | Tom  |
    | Beet |