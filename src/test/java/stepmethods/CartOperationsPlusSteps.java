package stepmethods;

import io.cucumber.java.an.E;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;
import org.junit.jupiter.api.Assertions;
import pageobjects.CartPO;
import pageobjects.ECommerceHomePO;

public class CartOperationsPlusSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();
    CartPO CartPO = new CartPO();
    String productNameHP;

    @Given("I added product item {int} to the cart")
    public void i_added_product_item_to_the_cart(Integer int1) {
        ECommerceHomePO.addProductToCart(int1);
        ECommerceHomePO.goToCart();
      }

    @When("I add {int} more of that item to the cart")
    public void i_add_more_of_item_to_the_cart(Integer int2) {
    CartPO.producInCartPlusButton(int2);


    }

    @Then("The cart contains {int} of that product")
    public void the_cart_contains_of_thet_product(Integer int3) {
        Assertions.assertEquals(int3.toString(), CartPO.cartItemQuantity(1));
    }
}