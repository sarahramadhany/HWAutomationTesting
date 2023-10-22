Feature: Add to Cart
  Scenario: Users can purchase products
    Given user is on login page
    When user enter the valid username and password
    And user click button login
    Then landing page should be displayed
    And user click add to cart one product
    And user click the cart icon
    And user click checkout
    And user enter the valid credentials add item
    And use click continue
    And use click finish
    Then checkout complete should be displayed

#  Scenario: Users can purchase products by verifying invalid checkout information data
#    Given user add products to cart and checkout products
#    When user click add to cart one product
#    And user click icon cart
#    And user adds quantity to the product
#    Then error in product quantity