package lesson16;

import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {

        String test = "someStringExample";

        System.out.println(test.isEmpty()); // пустой стринг или нет, булион значение или если ответ тру то значит стринг пустой

        System.out.println(test.length());  // длинна стринга

        System.out.println(test.charAt(2)); // находит букву (чар) на конкретной позиции

        System.out.println(test.replace("e", "T")); // заменяет выбраные букви другой буквой

        System.out.println(test.contains("me")); // содержит ли стринг последовательность чаров

        System.out.println(Arrays.toString(test.split("e"))); // разделяет стринг по всех буквах которые есть в стринге(чар)
        String phrase = "Hello there guys";
        System.out.println(Arrays.toString(phrase.split(" ")));// так делит стрнг по пробелам

        System.out.println(" test ".trim()); // проверка на то что начало стринга и конец будет без пробелов


        System.out.println(phrase.substring(5)); // удаляет все елементи в стринге до 5 индекса
        System.out.println(test.substring(3, 6)); // удаляет все елементи в стринге с 3 по 6 индекс
        System.out.println(phrase.substring(5, 10).trim()); // как можно совмещать методы

        System.out.println(test.toUpperCase()); // приводит все значения в стрнг в большие
        System.out.println(test.toLowerCase()); // приводит все значения в стрнг в маленькие

    }
}
