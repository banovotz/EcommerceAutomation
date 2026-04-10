package stepmethods;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.ECommerceHomePO;

public class EcomercePaginationSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();

    @Given("I am on the ecommerce {int} page")
    public void i_am_on_the_ecommerce_page(Integer int1) {
        Assertions.assertEquals("Basic Shopping Cart Web Testing App | Test Pages", ECommerceHomePO.pageTitle());
        ECommerceHomePO.goToPage(int1);
    }

    @When("I add item {int} to cart on the page")
    public void i_add_item_to_cart_on_the_page(Integer int1) {
        ECommerceHomePO.addProductToCart(int1);
    }

    @Then("{int} item is saved in the cart")
    public void item_is_saved_in_the_cart(Integer int2) {
        Assertions.assertEquals(ECommerceHomePO.readTheCart(), int2.toString());
    }
}