package lesson4;

public class MethodExample {
    public static void main(String[] args) {
        int res = increaser(5, 20);
        System.out.println(res);
        System.out.println(increaser(5,26));

        min(increaser(10,15), 11);

    }

    public static int increaser(int a, int index){
        System.out.println("method invoked");
        a += index;
        return a;
    }

    public static int min (int a, int b){
        if (a < b){
            return a;
        } else {
            return b;
        }

    }
}
