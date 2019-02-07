package lesson4.HomeWork;

public class MethodFindDivCount {
    public static void main(String[] args) {

        System.out.println(findDivCount((short) 1,(short) 20, 2));

    }



    public static int findDivCount(short a, short b, int n){

        int res = 0;
        for (int i = a; i <= b; i++){
            if (i % n == 0){
                res++;

            }
        }
        return res;
    }
}
