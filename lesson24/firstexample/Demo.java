package lesson24.firstexample;

public class Demo <T> {

    public static void main(String[] args) {
        calculatePrice(new FirstOrder());
        calculatePrice(new SecondOrder());


    }

    public void print(T t){
        System.out.println(t);

    }

    private static void calculatePrice(AbstractOrder abstractOrder){
        System.out.println(abstractOrder.getPrice());

    }

    private  static void calculatePrice(SecondOrder secondOrder){
        System.out.println(secondOrder.getPrice());
    }


}
