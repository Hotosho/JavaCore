package lesson16.HomeWork;

public class Solution {
    public static void main(String[] args) {
        String test = "Everything you need to know about the Boeing";
        String test1 = "";

        System.out.println(countWords(test));

    }


    public static int countWords(String input) {

        int counter = 0;

        String[] strings = input.split(" ");

        for (String werb : strings){
            if (checkWords(werb)){
                counter++;
            }
        }
        return counter;
    }


    private static boolean checkWords(String input){

        char[] chars = input.toCharArray();
        for (char letter : chars){
            if (!Character.isLetter(letter)){
                return false;
            }
        }
        return !input.isEmpty();
    }



    /*private static boolean checkNullString(String input) {
        if (!input.isEmpty())
            return true;
        else
            return false;
    }*/

    /*private static int countWordsString(String input) {

        input.split(" ");

        int counter = 0;
        for (int i = 0; i < input.length(); i++) {
            counter += i;
            i++;
        }
        return counter;
    }*/


}
