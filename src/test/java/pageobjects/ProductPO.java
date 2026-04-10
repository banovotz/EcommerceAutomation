package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import runtest.SetDriver;

public class ProductPO {
    private WebDriver driver;
    private static WebDriverWait wait;

    public ProductPO() {
        this.driver = SetDriver.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }
    public static String productTitleString() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productContainer > div.card > div.title"))).getAttribute("title");

        }
}