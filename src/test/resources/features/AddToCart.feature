Feature: Add to Cart

  Scenario: Add product to cart after login
    Given I am logged in
    When I add the first product to cart
    Then the cart should have one item