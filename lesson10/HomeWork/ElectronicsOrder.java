package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMoths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMoths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMoths = guaranteeMoths;
    }


    @Override
    void validateOrder() {

        if (getShipFromCity() == "Киев" || getShipFromCity() == "Oдесса" || getShipFromCity() == "Днепр" || getShipFromCity() == "Харьков"){
            if (getShipToCity() == "Киев" || getShipToCity() == "Oдесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков"){
                if (getBasePrice() >= 100 && getCustomerOwned().getGender() == "женский"){
                    setDateConfirmed(new Date());
                }
            }
        }
    }

    @Override
    void calculatePrice() {

        if (getShipFromCity() == "Киев" || getShipFromCity() == "Oдесса")
            setTotalPrice(getBasePrice() + getBasePrice() * 0.1);
        else
            setTotalPrice(getBasePrice() + getBasePrice() * 0.15);
        if (getBasePrice() > 1000)
            setTotalPrice(getTotalPrice() - getTotalPrice() * 0.05);
    }
}
