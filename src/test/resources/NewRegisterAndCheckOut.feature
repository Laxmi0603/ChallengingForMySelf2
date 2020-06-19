Feature: Create new register and performing the checkout

  In Order to perform the checkout
  As a new register
  I have to fill all the mandatory fields and add a item to the cart

  Scenario: create a new register and add item to the cart and performing checkout

    Given I navigate to url "http://twentyconsulting-001-site1.dtempurl.com/"
    When  I click on Register link
    Then  I should be navigated to Register page
    When  I click on Female Radio Button
    And   I enter firstname lastname email company name password confirmpassword
      |firstname|lastname|email                  |companyname     |password |confirmpassword|
      |lucky    |star    |luckystar72@testing.com|luckystarcompany|luckystar|luckystar      |
    And   I select Day Month Year
    And   I click on register button
    Then  I should see Your registration completed
    When  I click continue button
    Then  I should be navigated to user home page
    And   I click add to cart button for the first product
    And   I click on shopping cart link
    Then  I should be navigated to shopping cart page
    When  I click the terms of service check box
    And   I click on check out button
    Then  I should be navigated to checkout page
    When  I click country and select united kingdom
    And   I enter city address postcode phonenumber
      |city  |address |postcode|phonenumber|
      |london|56balmain|tw78ej  |07887555094|
    And   I click on continue button for billing address
    And   I set default shipping method
    And   I set default payment method
    And   I set default payment information
    And   I confirm the order
    Then  I should see the order confirmation msg "Your order has been successfully processed!"












