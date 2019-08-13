package lesson26.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class ArrayListTest {
    public static void main(String[] args) {


        System.out.println(Arrays.deepToString(useList()));
    }

    public static Order[] useList(){

        Order order1 = new Order(1, 100, "Dollar", "USA", "Green");
        Order order2 = new Order(2, 200,"Euro", "UE", "Blue");
        Order order3 = new Order(3, 300, "Uan", "CHINA", "Red");
        Order order4 = new Order(4, 400, "Test", "TESTIAN", "Qwe");
        Order order5 = new Order(5, 500, "Civ", "CIVILAZATION", "Vic");
        Order order6 = new Order(6, 345, "GTA", "SAN", "Andreas");
        Order order7 = new Order(7 ,765, "Zlotyj", "Pol", "Wroclaw");
        Order order8 = new Order(9, 45,"3424es", "we","sd");

        ArrayList<Order> list1 = new ArrayList<>();
        ArrayList<Order> list2 = new ArrayList<>();

        list1.add(order1);
        list1.add(order2);
        list1.clear();

        list1.add(order1);
        list1.add(0,order8);
        list1.remove(0);


        list2.add(order2);
        list2.add(order3);
        list2.add(order4);
        list2.add(order5);
        list2.add(order7);
        list2.remove(order7);

        list1.addAll(list2);

        list1.set(0, order7);
        list1.contains(order4);

        list1.subList(0, 3);

        return list1.toArray(new Order[5]);
    }


}
