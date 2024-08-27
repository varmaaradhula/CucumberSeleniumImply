Feature:  Place the order

  @PlaceOrder
  Scenario Outline: Search the product add to the cart  for the order
    Given User is on GreenCart landing page
    When User searched with shortname <Name> and extracted actual product
    And Added "3" items of the selected product to cart
    Then User proceeds to checkout and validate the <Name> items in checkout page
    And very user has ability to enter promo code and place the order
Examples:
    | Name |
    | Tom  |
