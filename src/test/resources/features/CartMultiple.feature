Feature: Multiple Products in Cart

  Scenario: Add two products to cart
    Given I am logged in
    When I add two products to cart
    Then the cart should have two items