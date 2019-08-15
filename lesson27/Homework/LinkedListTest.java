package lesson27.Homework;

import java.util.Arrays;
import java.util.LinkedList;


public class LinkedListTest {
    public static void main(String[] args) {

        System.out.println(Arrays.deepToString(useList()));
    }

    public static Order[] useList(){

        Order order1 = new Order(1, 100, "usa", "phone", "apple");
        Order order2 = new Order(2, 200, "eng", "tablet", "microsoft");
        Order order3 = new Order(3, 300, "chi", "spy", "huawej");
        Order order4 = new Order(4, 400, "ua", "kozak", "sich");
        Order order5 = new Order(5, 500, "pol", "wroclaw", "zloty");
        Order order6 = new Order(6, 600, "beer", "berlin", "paruwka");
        Order order7 = new Order(7, 700, "esp", "barselona", "club");
        Order order8 = new Order(8, 800, "joker", "atom", "super");
        Order order9 = new Order(9, 900, "test", "test", "test");

        LinkedList<Order> linkedList1 = new LinkedList<>();
        LinkedList<Order> linkedList2 = new LinkedList<>();

        linkedList1.add(order1);
        linkedList1.add(1, order2);
        linkedList1.clear();

        linkedList1.add(order1);
        linkedList1.add(1, order2);
        linkedList1.remove(1);

        linkedList2.add(order3);
        linkedList2.add(order4);
        linkedList2.add(order5);
        linkedList2.add(order6);
        linkedList2.add(order7);
        linkedList2.add(order9);
        linkedList2.remove(order7);

        linkedList1.addAll(linkedList2);

        linkedList1.set(1, order8);
        linkedList1.contains(order1);

        linkedList1.subList(0,5);

        return linkedList1.subList(0,5).toArray(new Order[5]);
    }
}
