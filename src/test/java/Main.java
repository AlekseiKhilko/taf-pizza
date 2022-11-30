public class Main {
    public static void main(String[] args) throws InterruptedException {
        //System.out.println("Hello world!");
        Pizza pizza = new Pizza();
        pizza.startdriver()
                .openMainPage()
                //.clickPizza()
                .clickBuy()
                .clickCart()
                .clickCart()
                .checkPizza();
        //pizza.openMainPage();
    }
}