package lesson4.HomeWork;

public class MethodConcat {
    public static void main(String[] args) {

        System.out.println(concat("I ", "love ", "NewYork"));

    }


    public static String concat(String a, String b, String c){

        String res = a + b + c;

        return res;
    }
}
