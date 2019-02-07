package lesson8.HomeWork;

public class Demo {
    public static void main(String[] args) {

        int[]testArray = {34,12,56,67,34,45,61};


        Adder adder = new Adder();
        System.out.println(adder.check(testArray));
        System.out.println(adder.add(88,88));
    }
}
