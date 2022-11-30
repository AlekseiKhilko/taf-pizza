import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = StartDriver.get();

        Pizza pizza = new Pizza();
        pizza.setDriver(driver);
        pizza.openPage()
                .clickBuyPizza()
                .clickCart()
                .checkPizza();

        StartDriver.close(pizza.getDriver());
    }
}