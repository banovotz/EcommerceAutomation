package stepmethods;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import pageobjects.ECommerceHomePO;
import pageobjects.ProductPO;

public class ProductSteps {
    ECommerceHomePO ECommerceHomePO = new ECommerceHomePO();
    ProductPO ProductPO = new ProductPO();
    String productNameHP;


    @Given("I visited the ecommerce home page")
    public void i_visited_the_ecommerce_home_page() {


        Assertions.assertEquals("Basic Shopping Cart Web Testing App | Test Pages", ECommerceHomePO.pageTitle());
    }

    @When("I open the product item {int} page")
    public void i_open_the_product_item_page(Integer int1) {
        productNameHP = ECommerceHomePO.readTheProductTitleOnHomePage(int1);
        ECommerceHomePO.goToProduct(int1);
    }

    @Then("I am on expected product item {int} page")
    public void i_am_on_expected_product_item_page(Integer int2) {
        Assertions.assertEquals(productNameHP, ProductPO.productTitleString());
    }
}