package lesson15.cast;

public class Demo {
    public static void main(String[] args) {

        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();

        System.out.println(provider);
    }

    static Provider test(){
        // some logic
        return new InternetProvider();
    }

    static Provider testFood(){
        // some logic
        return new InternetProvider();
    }
}
