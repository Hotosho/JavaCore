package lesson6;

public class Car {

    //1 fields or свойства
    int price;
    int yearOfManufacting;
    String color;
    String ownerName;
    double weight;
    int hoursePower;



    //2 constructors


    public Car(int price, int yearOfManufacting, String ownerName) {
        this.price = price;
        this.yearOfManufacting = yearOfManufacting;
        this.ownerName = ownerName;
    }

    //3 methods
    void startRun(){
        System.out.println("I am running....");
    }
    void stopRun(){
        System.out.println("I am stop....");
    }

    void changeOwner(String newOwnerName){
        ownerName = newOwnerName;
    }


}
