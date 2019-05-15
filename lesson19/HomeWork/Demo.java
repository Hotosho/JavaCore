package lesson19.HomeWork;

public class Demo {
    public static void main(String[] args) {

        try {
            File file1 = new File(999, "testName", "qwert", 32);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            File file2 = new File(345, "1Name", "qwert", 2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        try {
            File file3 = new File(23, "2Name", "asdf", 54);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
