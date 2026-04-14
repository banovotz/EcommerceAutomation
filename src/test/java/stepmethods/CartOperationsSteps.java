package stepmethods;

import io.cucumber.java.an.E;
import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.CartPO;
import pageobjects.ECommerceHomePO;

public class CartOperationsSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();
    CartPO CartPO = new CartPO();
    String productNameHP;

    @Given("I added product item {int} to cart")
    public void i_added_product_item_to_cart(Integer int1) {
        ECommerceHomePO.addProductToCart(int1);
        ECommerceHomePO.goToCart();
      }

    @When("I remove the item {int} from the cart")
    public void i_remove_the_item_from_the_cart(Integer int1) {
    CartPO.producInCartMinusButton(int1);
    CartPO.producInCartRemoveButton(int1);

    }

    @Then("The cart is empty")
    public void the_cart_is_empty() {
        Assertions.assertEquals("Your cart is empty.", CartPO.emptyCart());
    }
}