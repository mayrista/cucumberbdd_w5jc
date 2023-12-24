Feature: Add to Cart and Co
  #1
  Scenario: Add to cart
    Given Admin Login web Sauce Demo
    When Admin click button add to cart from item
    And Admin click button cart

  #2
  Scenario: CheckoutNegatif
    Given Admin click button checkout
    And Admin enter null first and lastname and postalcode
    And Admin click button Continue
    Then Admin error required

  #3
  Scenario: Checkout
    And Admin enter first and lastname and postalcode
    And Admin click button Continue
    And Admin click button finish
    And Admin click back home
    Then Admin successful checkout redirect page dashboard
    And Admin Logout
