package org.example;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");
        Pizza pizza = new Pizza();
        pizza.startdriver()
                .openMainPage()
                .clickPizza()
                .clickBuy()
                .clickCart()
                .clickCart();
        //pizza.openMainPage();
    }
}