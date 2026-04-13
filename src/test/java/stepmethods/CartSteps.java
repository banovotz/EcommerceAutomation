package stepmethods;

import io.cucumber.java.an.E;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.CartPO;
import pageobjects.ECommerceHomePO;

public class CartSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();
    CartPO CartPO = new CartPO();
    String productNameHP;

    @Given("I am on the ecommerce home")
    public void i_am_on_the_ecommerce_home() {
        Assertions.assertEquals("Basic Shopping Cart Web Testing App | Test Pages", ECommerceHomePO.pageTitle());
    }

    @When("I add the product item {int} to cart")
    public String i_add_the_product_item_to_cart(Integer int1) {
        ECommerceHomePO.addProductToCart(int1);
        productNameHP = ECommerceHomePO.readTheProductTitleOnHomePage(int1);
        return productNameHP;
    }

    @And("I go to the cart")
    public void i_go_to_the_cart() {
        ECommerceHomePO.goToCart();
    }

    @Then("The cart contains that product item {int}")
    public void the_cart_contains_that_product_item(Integer int2) {

        Assertions.assertEquals(productNameHP, CartPO.productInCartTitleString(int2));
    }
}