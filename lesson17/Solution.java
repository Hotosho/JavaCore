package lesson17;

public class Solution {
    public static void main(String[] args) {
        String test = "Everything you need to know about the Boeing";


        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));

    }


    public static int countWords(String input) {

        int counter = 0;

        String[] strings = input.split(" ");

        for (String werb : strings) {
            if (checkWords(werb)) {
                counter++;
            }
        }
        return counter;
    }


    private static boolean checkWords(String input) {

        char[] chars = input.toCharArray();
        for (char letter : chars) {
            if (!Character.isLetter(letter)) {
                return false;
            }
        }
        return !input.isEmpty();
    }

    public static String maxWord(String input) {

        if (input == null)
            return null;

        String[] strings = input.split(" ");
        String maxWord = strings[0];

        for (String stringMax : strings) {
            if (checkWords(stringMax)) {
                if (stringMax.length() > maxWord.length())
                    maxWord = stringMax;

            }
        }
        return maxWord;
    }

    public static String minWord(String input) {

        if (input == null)
            return null;

        String[] strings = input.split(" ");
        String minWord = strings[0];

        for (String stringMin : strings) {
            if (checkWords(stringMin)) {
                if (stringMin.length() < minWord.length())
                    minWord = stringMin;
            }
        }
        return minWord;
    }


}
