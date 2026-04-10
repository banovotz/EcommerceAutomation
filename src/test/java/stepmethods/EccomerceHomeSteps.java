package stepmethods;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.ECommerceHomePO;

public class EccomerceHomeSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();

    @Given("I am on the ecommerce home page")
    public void i_am_on_the_ecommerce_home_page() {
        Assertions.assertEquals("Basic Shopping Cart Web Testing App | Test Pages", ECommerceHomePO.pageTitle());
    }

    @When("I add {int} item to cart")
    public void i_add_item_to_cart(Integer int1) {
        ECommerceHomePO.addProductToCart(1);
    }

    @Then("one item is in the cart")
    public void one_item_is_in_the_cart() {
        Assertions.assertEquals(ECommerceHomePO.readTheCart(), "1");
    }
}