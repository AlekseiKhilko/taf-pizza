public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Pizza pizza = new Pizza();
        pizza.startdriver()
                //.clickPizza()
                .clickBuy()
                .clickCart()
                .clickCart()
                .checkPizza();
        //pizza.openMainPage();
    }
}