# language: en

Feature: cart
    Scenario Outline: Adding products to cart
        Given I am on the ecommerce home
        When I add the product item <number1> to cart
        And I go to the cart
        Then The cart contains that product item <expected>

        Examples:
            | number1 | expected |
            | 1       | 1        |
            | 2       | 1        |

    Scenario Outline: Removing product from cart with minus control
        Given I added product item <number1> to cart
        When I remove the item <expected> from the cart
        Then The cart is empty

        Examples:
            | number1 |expected |
            | 1       |1        |
            | 2       |1        |