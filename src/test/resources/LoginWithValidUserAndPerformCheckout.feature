Feature: login to the NopCommerce website with  valid credentials

  In order to login to the nop
  As a valid user
  I have to enter email and password

  Scenario: Verify existing user login details and perform checkout for the same user
    Given I navigate to url "http://twentyconsulting-001-site1.dtempurl.com/"
    When  I click on login link
    Then  I should be navigated to login page
    When  I enter email 'lucky.star@gmail.com'
    And   I enter password 'Luckystar'
    And   I click login button
    Then  I should be navigated to user login page and i should see msg "Welcome to our store"
    And   I click add to cart button for the first product
    And   I click on shopping cart link
    Then  I should be navigated to shopping cart page
    When  I click the terms of service check box
    And   I click on check out button
    Then  I should be navigated to checkout page
    When   I click on continue button for billing address
    And   I set default shipping method
    And   I set default payment method
    And   I set default payment information
    And   I confirm the order
    Then  I should see the order confirmation msg "Your order has been successfully processed!"

