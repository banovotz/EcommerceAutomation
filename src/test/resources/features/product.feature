# language: en

Feature: product page
    Scenario Outline: Opening the product page
        Given I visited the ecommerce home page
        When I open the product item <number1> page
        Then I am on expected product item <expected> page

        Examples:
            | number1 | expected |
            | 1       | 1        |
            | 2       | 2        |

