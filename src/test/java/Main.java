import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        StartDriver startDriver = new StartDriver();
        WebDriver driver = startDriver.start();

        Pizza pizza = new Pizza();
        pizza.setDriver(driver);
        pizza.openPage()
                .clickBuy()
                .clickCart()
                .checkPizza();
    }
}