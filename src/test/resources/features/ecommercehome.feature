# language: en

Feature: eccomerce home
    Scenario Outline: Adding items to cart
        Given I am on the ecommerce home page
        When I add <number1> item to cart
        Then <expected> item is in the cart

        Examples:
            | number1 | expected |
            | 1       | 1        |
            | 2       | 1        |

