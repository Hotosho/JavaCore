package lesson3.HomeWork;

public class FindOdd {
    public static void main(String[] args) {

        int a;
        int sum = 0;

        for (a = 0; a <= 1000; a++){
            if (a % 2 != 0)
                System.out.println("Found = " + a);
        }

        sum = sum + a;
        int sumResult = sum * 5;
        if (sumResult > 5000){
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
