package lesson17;

public class Solution {
    public static void main(String[] args) {
        String test = "444Everything you need to know about the the Boeing";
        String link = "https://githab.com";


        System.out.println(countWords(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));
        System.out.println(mostCountedWord(test));
        System.out.println(validate(link));

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

        for (String word : words) {
            if (word.length() > 0 && checkWords(word)) {
                maxWord = word;
                break;
            }
        }
        if (maxWord == null)
            return null;

        for (String word : words) {
            if (word.length() > maxWord.length() && checkWords(word)) {
                maxWord = word;
            }
        }

        return maxWord;

    }

    public static String minWord(String input) {

        String[] words = input.split(" ");

        if (words.length == 0)
            return null;

        String minWord = null;

        for (String word : words) {
            if (word.length() > 0 && checkWords(word)) {
                minWord = word;
                break;
            }
        }
        if (minWord == null)
            return null;

        for (String word : words) {
            if (word.length() < minWord.length() && checkWords(word)) {
                minWord = word;
            }
        }
        return minWord;
    }

    public static String mostCountedWord(String input) {

        String[] words = input.split(" ");

        if (words.length == 0)
            return null;

        String mostCountWord = null;

        for (String word : words) {
            if (word.length() > 0 && checkWords(word)) {
                mostCountWord = word;
                break;
            }
        }

        int mostCounter = 0;

        for (String word : words) {
            int count = 0;
            for (String word1 : words) {
                if (word.equals(word1) && word.length() > 0 && checkWords(word1)) {
                    count++;
                }
            }
            if (count > mostCounter) {
                mostCounter = count;
                mostCountWord = word;
            }
        }


        return mostCountWord;
    }

    public static boolean validate(String address) {

        if (address == null)
            return false;
        String link = address.trim();

        if (!link.startsWith("https://") || !link.startsWith("http://"))
            return false;
        if (!link.endsWith(".com") && !link.endsWith(".net") && !link.endsWith(".org"))
            return false;

        return checkLink(link);
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

    private static boolean checkLink(String input) {

        char[] chars = input.trim().toCharArray();

        for (char ch : chars) {
            if (!Character.isLetterOrDigit(ch))
                return false;
        }
        return true;
    }


}
