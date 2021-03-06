package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {

    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }


    @Override
    public void validateOrder() {

        if (getShipFromCity() == "Киев" || getShipFromCity() == "Львов") {
            if (getShipToCity() == "Киев" || getShipToCity() == "Oдесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков") {
                if (getBasePrice() >= 500 && getCustomerOwned().getName() != "Тест") {
                    setDateConfirmed(new Date());
                }
            }
        }
    }

    @Override
    public void calculatePrice() {
        if (getBasePrice() > 5000)
            setTotalPrice(getBasePrice() + (getBasePrice() / 100 * 2));
        else
            setTotalPrice(getBasePrice() + (getBasePrice() / 100 * 5));
    }
}
