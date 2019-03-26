package lesson17;

public class Solution {
    public static void main(String[] args) {
        String test = "444Everything you need to know about the Boeing";


        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));

    }


    public static int countWords(String input) {

        int counter = 0;

        String[] strings = input.split(" ");

        for (String word : strings) {
            if (checkWords(word)) {
                counter++;
            }
        }
        return counter;
    }

    public static String maxWord(String input) {

        int maxCount = 0;
        int counter = 0;
        String[] arrayWords = input.split(" ");
        for (String word1 : arrayWords) {
            for (String word2 : arrayWords) {
                if (word1.equals(word2) && word1.length() > 0 && checkWords(word2))
                    counter++;
            }
            if (counter > maxCount) {
                maxCount = counter;
                input = word1;
            }
        }
        return input;
    }

    public static String minWord(String input) {

        if (input == null)
            return null;

        String[] strings = input.split(" ");
        String minWord = strings[0];

        for (String minString : strings) {
            if (checkWords(minString)) {
                if (minString.length() < minWord.length())
                    minWord = minString;
            }
        }
        return minWord;
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

}
