package lesson19;

public class ThrowExample {
    private static String[] array = {"test", "test1", "tesqwd", "adsasf", "sdfsdf", null};

    public static void main(String[] args) {

        //test();
        useOfTestMethod();
    }



    private static void test() throws Exception {
        for(String element : array){
            if (element == null)
                throw new RuntimeException("null id detected");
        }
        System.out.println("done");
    }

    private static void useOfTestMethod(){
        try {
            //some code
            test();
            //some code
        }catch (Exception e){
            System.out.println("error" + e.getMessage());
        }

    }
}
