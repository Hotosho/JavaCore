package lesson18.HomeWork;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String str = new String("MacBook Air 2015 and 2017 or Pro 2019");
        System.out.println(Arrays.toString(findNumbers(str)));
    }


    public static int[] findNumbers(String text) {
        String[] words = text.split(" ");

        int count = 0;
        for (String w : words) {
            if (checkNumber(w))
                count++;
        }

        int[] result = new int[count];
        int j = 0;

        for (String w : words) {
            try {
                result[j] = Integer.parseInt(w);
                j++;
            } catch (Exception e) {
                System.out.println("not a number");
            }

        }
        return result;
    }


    private static boolean checkNumber(String word) {
        boolean checkNumber = false;
        int c = 0;
        if (!word.isEmpty()) {
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (Character.isDigit(ch)) {
                    c++;
                }
            }
        }
        if (!word.isEmpty() && c == word.length()) {
            checkNumber = true;
        }
        return checkNumber;

    }
}
