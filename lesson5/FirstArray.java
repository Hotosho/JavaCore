package lesson5;

import java.util.Arrays;

public class FirstArray {
    public static void main(String[] args) {

        //type of array [] name of array = new type of array[lenght of array]
        int[]firstArray = new int[3];

        //array name [index] - get array element
        firstArray[0] = 11;
        firstArray[1] = 200;
        firstArray[2] = -10;

        System.out.println(firstArray[0]);
        System.out.println(firstArray[1]);
        System.out.println(firstArray[2]);

        //тоже вывод 3ех елементов масива
        for (int i = 0; i < 3; i++){
            System.out.println(firstArray[i]);
        }

        //the same up array
        for (int i = 0; i < firstArray.length; i++){
            System.out.println(firstArray[i]);
        }

        // .toString выводит в красивом виде наш масив
        System.out.println(Arrays.toString(firstArray));


        int d = 10;
        // создания масива в одну строку
        int[]secondArray = {1,10,15,20,-50};
        System.out.println(Arrays.toString(secondArray));

        //for-each
        for (int element : secondArray){
            System.out.println(element );
        }

        for (int i = 0; i < firstArray.length; i++){
            int element = firstArray[i];
            System.out.println(element);
        }


    }
}