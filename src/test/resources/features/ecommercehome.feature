# language: en

Feature: eccomerce home
    Scenario Outline: Adding items to cart
        Given I am on the ecommerce home page
        When I add item <number1> to cart
        Then <expected> item is in the cart

        Examples:
            | number1 | expected |
            | 1       | 1        |
            | 2       | 1        |

    Scenario Outline: Adding items to cart from other pages
        Given I am on the ecommerce <pagenumber> page
        When I add item <number1> to cart on the page
        Then <expected> item is saved in the cart

        Examples:
            |pagenumber | number1 | expected |
            |2          | 1       | 1        |
            |3          | 2       | 1        |

