package lesson5.HomeWork;
import java.util.Arrays;

public class ArraySort {
    public static void main(String[] args) {

        int[] array = {10, 50, 23, 8, 100, 1995, 1500, 2018};
        System.out.println(Arrays.toString(sortAscending(array)));
        System.out.println(Arrays.toString(sortDescending(array)));

    }

    static int[] sortAscending(int[] array){
        for (int i = array.length - 1; i > 0; i--){
            for (int j = 0; j < i; j++){
                if (array[j] > array[j + 1]){
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array;
    }


    static int[] sortDescending(int[] array) {

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }
        return array;
    }
}
