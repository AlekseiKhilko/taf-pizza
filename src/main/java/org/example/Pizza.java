package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

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

    public void Pizza(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
    }

    public void openMainPage(){
        final String URL = "https://express-pizza.by/";
        this.driver.get(URL);
    }

    /*
    // a[@href="/picca"]
    // //h3[text()='Маргарита']/..//button
    // a[@href="/cart/checkout"]
    // //form[@action='/cart/checkout']//a[contains(text(), 'Маргарита')]

     */
}
