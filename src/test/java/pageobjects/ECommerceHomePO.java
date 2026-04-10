package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import runtest.SetDriver;
import static java.lang.Character.isDigit;

public class ECommerceHomePO {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartCount = By.id("cartCount");

    public ECommerceHomePO() {
        this.driver = SetDriver.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

  public void addProductToCart(Integer position) {

      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productGrid > div:nth-child(" + position + ") > div:nth-child(5) > button.add")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
      
  }
    public String pageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
        return driver.getTitle();
    }

  public String readTheCart() {
        String cartCountState = wait.until(ExpectedConditions.presenceOfElementLocated(cartCount)).getText();
        return cartCountState;
  }
}