package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Pizza {

    public WebDriver driver;

    public Pizza startdriver(){
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return this;
    }

    public void closeDriver(){
        driver.close();
    }

    public Pizza openMainPage(){
        final String URL = "https://express-pizza.by/";
        this.driver.get(URL);

        return this;
    }

    public Pizza clickPizza() throws InterruptedException {
        final String xPath = "//a[@href='/picca']/img";
        WebElement element = driver.findElement(By.xpath(xPath));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
/*
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.release().perform();

        Thread.sleep(4000);
*/
        //element.click();
        return this;
    }

    public Pizza clickBuy(){
        //final String xPath = "//h3[text()='Маргарита']/..//button";
        final String xPath = "//div[@id='edit-actions--48']";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        //System.out.println(element.getText());

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
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
        //Маргарита30
        System.out.println(element.getText());
        return this;
    }

}
