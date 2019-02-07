package lesson4.HomeWork;

public class MethodCompareSums {
    public static void main(String[] args) {

        System.out.println(compareSums(9,89,1,6));

    }



    public static boolean compareSums(int a, int b, int c, int d){

        return sum(a, b) > sum(c, d);
    }

    public static long sum (int from, int to){

        long res = 0;
        for (long i = from; i <= to; i++){
            res+= i;
        }
        return res;
    }
}
