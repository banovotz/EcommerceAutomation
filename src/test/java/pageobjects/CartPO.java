package pageobjects;

import io.cucumber.java.an.E;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import runtest.SetDriver;

public class CartPO {
    private WebDriver driver;
    private static WebDriverWait wait;

    public CartPO() {
        this.driver = SetDriver.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    public static String productInCartTitleString(Integer int1) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartContainer > div:nth-child(" + int1 +") > div.title "))).getAttribute("title");

        }
    public void producInCartMinusButton(Integer int2) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartContainer > div:nth-child(" + int2 + ") > div:nth-child(5) > div > button.qty-minus"))).click();
    }

    public void producInCartPlusButton(Integer int3) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartContainer > div:nth-child(" + int3 + ") > div:nth-child(5) > div > button.qty-plus"))).click();
    }

    public void producInCartRemoveButton(Integer int4) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartContainer > div:nth-child(" + int4 + ") > div:nth-child(5) > button"))).click();
    }

    public void cartCheckoutButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#checkoutBtn"))).click();
    }

    public String emptyCart() {
        String emptyCartText = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartContainer > p"))).getText();
        return emptyCartText;
         }
}