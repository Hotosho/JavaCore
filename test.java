

public class test {
    public static void main(String[] args) {
        String test = "444Everything you need to know about the Boeing";
        System.out.println(maxWord(test));
    }


    public static String maxWord(String input) {
        if (input == null)
            return null;
        String[] strings = input.split(" ");
        String maxWord = "";
        for (String maxString : strings) {
            if (checkWords(maxString)) {
                if (maxString.length() > maxWord.length())
                    maxWord = maxString;
            }
        }
        return maxWord;
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
