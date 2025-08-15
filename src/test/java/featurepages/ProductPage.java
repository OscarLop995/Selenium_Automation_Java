package featurepages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;


public class ProductPage {
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToHomePage() {
        driver.get("https://automationexercise.com/");
    }

    By firstViewProduct = By.xpath("(//a[contains(text(),'View Product')])[1]");
    By addToCarProduct = By.xpath("(//button[normalize-space()='Add to cart'])[1]");
    By productAdded = By.xpath("(//h4[normalize-space()='Added!'])[1]");

    public void clickFirstViewProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(firstViewProduct)
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public void verifyFirstViewProduct(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCarProduct));
        Assert.assertTrue(element.isDisplayed(),
                "El botón 'Add to cart' no está visible en la página de detalles");
    }

    public void clickAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addToCarProduct));
        element.click();
    }

    public void verifyAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(productAdded));
        Assert.assertTrue(element.isDisplayed(),
                "El producto no pudo ser añadido al carrito");
    }
}