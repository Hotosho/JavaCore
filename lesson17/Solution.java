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

        String[] words = input.split(" ");

        if (words.length == 0)
            return null;

        String maxWord = null;

        for (String word : words){
            if (word.length() > 0 && checkWords(word)){
                maxWord = word;
                break;
            }
        }
        if (maxWord == null)
            return null;

        for (String word : words){
            if (word.length() > maxWord.length() && checkWords(word)){
                maxWord = word;
            }
        }

        return maxWord;

        /*if (input == null)
            return null;
        String[] strings = input.split(" ");
        String maxWord = "";
        for (String maxString : strings) {
            if (checkWords(maxString)) {
                if (maxString.length() > maxWord.length())
                    maxWord = maxString;
            }
        }
        return maxWord;*/
    }

    public static String minWord(String input) {

        String[] words = input.split(" ");

        if (words.length == 0)
            return null;

        String minWord = null;

        for (String word : words){
            if (word.length() > 0 && checkWords(word)){
                minWord = word;
                break;
            }
        }
        if (minWord == null)
            return null;

        for (String word : words){
            if (word.length() < minWord.length() && checkWords(word)){
                minWord = word;
            }
        }
        return minWord;

        /*if (input == null)
            return null;

        String[] strings = input.split(" ");
        String minWord = strings[0];

        for (String minString : strings) {
            if (checkWords(minString)) {
                if (minString.length() < minWord.length())
                    minWord = minString;
            }
        }
        return minWord;*/
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
