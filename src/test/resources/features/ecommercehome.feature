# language: en

Feature: eccomerce home
    Scenario Outline: Adding one item to cart
        Given I am on the ecommerce home page
        When I add <number1> item to cart
        Then one item is in the cart

        Examples:
            | number1 |
            | 1       |

