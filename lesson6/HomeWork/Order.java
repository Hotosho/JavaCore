package lesson6.HomeWork;

import java.util.Date;

public class Order {

    public long id;
    public int price;
    public Date dateCreated;
    public boolean isConfirmed;
    public Date dateConfirmed;
    public String city;
    public String country;
    public String type;

    public Order() {
    }

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public void confirmOrder(){
        if (!isConfirmed) {
            isConfirmed = true;
            dateConfirmed = new Date();
        }

    }

    public boolean checkPrice(){
        return price > 1000;
    }

    public boolean isValidType(){
        return type.equals("Buy") || type.equals("Sale");
    }


}
