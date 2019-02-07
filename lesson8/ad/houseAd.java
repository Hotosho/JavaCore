package lesson8.ad;

public class houseAd extends ad {

    String ownerName;
    String adress;
    double square;
    int floors;

    public houseAd(long id, int price, String adress, double square, int floors) {
        super(id, price);
        this.adress = adress;
        this.square = square;
        this.floors = floors;
    }

    boolean checkOwner(){
        owners owners = new owners();

        for (String owner : owners.owners){
            if (ownerName == owner)
                return true;
        }
        return false;
    }
}
