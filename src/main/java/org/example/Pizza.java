package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Pizza {

    public WebDriver driver;

    /*
    Задание (обязательное)
1. Зайти на домашнюю страницу сайта. https://express-pizza.by/
2. В разделе Пицца(-ы) добавить в Корзину пиццу Маргарита (или Четыре сезона) любого размера.
3. Перейти в Корзину.
4. Проверить, что пицца Маргарита (или Четыре (4) сезона) есть в заказе.
*если для выполнения заказа необходимы дополнительные данные, то ваше усмотрение
     */

    public Pizza startdriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return this;
    }

    public Pizza openMainPage(){
        final String URL = "https://express-pizza.by/";
        this.driver.get(URL);

        return this;
    }

    public Pizza clickPizza(){
        final String xPath = "//a[@href='/picca']";
        WebElement element = driver.findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.release().perform();

        js.executeScript("arguments[0].scrollIntoView();", element);

        element.click();
        return this;
    }

    public Pizza clickBuy(){
        final String xPath = "//h3[text()='Маргарита']/..//button";
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.click();
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
        WebElement element = driver.findElement(By.xpath(xPath));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        System.out.println(element.getText());
        return this;
    }

    /*
    // a[@href="/picca"]
    // //h3[text()='Маргарита']/..//button
    // a[@href="/cart/checkout"]
    // //form[@action='/cart/checkout']//a[contains(text(), 'Маргарита')]

     */
}
