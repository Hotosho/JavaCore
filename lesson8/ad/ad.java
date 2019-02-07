package lesson8.ad;

import java.util.Date;

public class ad extends BaseEntity {


    int price;
    Date dateCreated;

    public ad(long id, int price) {
        super(id);
        this.price = price;
        this.dateCreated = new Date();
    }

    void publishAd(){

    }
}
