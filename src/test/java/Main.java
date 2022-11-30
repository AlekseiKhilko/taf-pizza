import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");

        StartDriver startDriver = new StartDriver();
        WebDriver driver = startDriver.start();

        Pizza pizza = new Pizza();
        pizza.setDriver(driver);
        pizza.openPage()
                //.clickPizza()
                .clickBuy()
                .clickCart()
                .clickCart()
                .checkPizza();
        //pizza.openMainPage();
    }
}