package lesson16;

import java.util.Arrays;

public class StringCompare {
    public static void main(String[] args) {

        System.out.println(new String("abc") == new String("abc"));
        System.out.println(new String("abc").equals(new String("abc")));




        System.out.println("abc" == "abc"); // оператор == делает сравниение ссылок
        System.out.println("abc".equals("abc")); // тут проверка по буквам ( чарам) сравнение

        //getBytes();
        String str = "testStringVar";
        System.out.println(Arrays.toString(str.getBytes()));

        //intern(); этот метод насильно отправляет стринг в пул ( басейн памяти)

    }
}
