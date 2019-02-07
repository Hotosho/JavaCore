package lesson2.HomeWork;
public class SumAndDivision {
    public static void main(String[] args) {

        int a = 0;
        int sum = 0;
        int number = 1234;

        while (a <= 1000) {
            sum += a;
            a++;
        }

        int div = sum / number;
        int mod = sum % number;

        while (mod > div) {
            System.out.println(true);
            while (mod < div) {
                System.out.println(false);
            }
            break;
        }
    }
}
