package lesson6;

public class Demo {
    public static void main(String[] args) {
        Car carObject = new Car(10000, 2015, "Anton");

        System.out.println(carObject.color);
        System.out.println(carObject.hoursePower);
        System.out.println(carObject.ownerName);

        carObject.hoursePower = 100;
        System.out.println(carObject.hoursePower);

        carObject.startRun();
        carObject.stopRun();

        carObject.changeOwner("TestOwner");
        System.out.println(carObject.ownerName);

        Car carObject2 = null;

    }
}
