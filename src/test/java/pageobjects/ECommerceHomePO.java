package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import runtest.SetDriver;

public class ECommerceHomePO {
    private WebDriver driver;
    private WebDriverWait wait;

    private By cartCount = By.id("cartCount");

    public ECommerceHomePO() {
        this.driver = SetDriver.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public String pageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
        return driver.getTitle();
    }

    public void addProductToCart(Integer value) {
        String valueStr = String.valueOf(value);
        for (char position : valueStr.toCharArray()) {
      WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productGrid > div:nth-child(" + position + ") > div:nth-child(5) > button.add")));
      ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    }

    public void goToPage(Integer pageNumber) {
        Integer realPageNumber = pageNumber + 1;
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#pagination > button:nth-child(" + realPageNumber  + ")")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public String goToProduct(Integer productNumber) {
        By productId = By.cssSelector("#productGrid > div:nth-child(" + productNumber + ") > div.title)");
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productGrid > div:nth-child(" + productNumber +") > div:nth-child(5) > button.view")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        return productId.toString();
    }

    public final String readTheProductTitleOnHomePage(Integer productNumber) {
      return wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#productGrid > div:nth-child(" + productNumber + ") > div.title"))).getAttribute("title");
    }

    public void goToCart() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#cartCount"))).click();
    }
    public String readTheCart() {
        String cartCountState = wait.until(ExpectedConditions.presenceOfElementLocated(cartCount)).getText();
        return cartCountState;
    }


}