package lesson19;

public class RunTimeExceptionExample {

    public static void main(String[] args) {

        // arithmetic exception
        arithmeticException(2);
        try {
            arithmeticException(0);
        } catch (Exception e) {
            System.out.println("something wrong");
        }

        //nullPointException
        npe(new Object());
        npe(null);
    }

    private static void arithmeticException(int a) {
        System.out.println(10 / a);
    }

    private static void npe(Object object){

        System.out.println(object.hashCode());
    }
}
