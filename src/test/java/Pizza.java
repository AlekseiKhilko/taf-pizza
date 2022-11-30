import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.gen5.api.Assertions.assertEquals;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Pizza {
    public WebDriver driver;

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public Pizza openPage(){

        final String URL = "https://express-pizza.by/";
        this.driver.get(URL);

        return this;
    }

    public void closeDriver(){
        driver.close();
    }

    public Pizza clickPizza() throws InterruptedException {
        final String xPath = "//a[@href='/picca']/img";
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        return this;
    }

    public Pizza clickBuy(){
        //final String xPath = "//h3[text()='Маргарита']/..//button";
        final String xPath = "//div[@id='edit-actions--48']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        return this;
    }

    public Pizza clickCart(){
        final String xPath = "//a[@href=\"/cart/checkout\"]";
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
        return this;
    }

    public Pizza checkPizza(){
        final String xPath = "//form[@action='/cart/checkout']//a[contains(text(), 'Маргарита')]";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        String expectedString = element.getText();
        assertEquals(expectedString, "Маргарита30");

        return this;
    }

}
