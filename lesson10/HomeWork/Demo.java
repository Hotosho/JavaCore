package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Customer customer = new Customer("Pavlo", "Wroclaw", "men");

        Order order = new ElectronicsOrder("iPhone", new Date(), "Львов", "Киев", 900,
                customer, 24);
        Order order2 = new ElectronicsOrder("MacBook", new Date(), "Харьков", "Киев", 1999,
                customer, 36);


        Order order3 = new FurnitureOrder("CloudIkea", new Date(), "Харьков", "Львов", 699,
                customer, "rarCode");
        Order order1 = new FurnitureOrder("IkeaSofa", new Date(), "Киев", "Одесса", 199,
                customer, " zipCode");


        order.validateOrder();
        order.calculatePrice();
        order.confirmShipping();

        order1.validateOrder();
        order1.calculatePrice();
        order1.confirmShipping();

        order2.validateOrder();
        order2.calculatePrice();
        order2.confirmShipping();

        order3.validateOrder();
        order3.confirmShipping();
        order3.calculatePrice();
    }
}
