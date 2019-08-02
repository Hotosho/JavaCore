package lesson25;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) throws Exception {

        GeneralDAO generalDAO = new GeneralDAO();

        Order order = new Order(1);
        generalDAO.validate(order);


        TestClass<String, Order, Long> testClass = new TestClass();
        System.out.println(testClass.doSomething1("rrr"));

        int test = 100;
        Long variable2 = new Long(222);

        generalDAO.validate(variable2);
        generalDAO.validate(test);

        Order order1 = new Order(111);
        Order order2 = new Order(222);
        Order order3 = new Order(333);

        Long long1 = new Long(333);
        Long long2 = new Long(444);
        Long long3 = new Long(555);

        String string1 = ("test1");
        String string2 = ("test2");
        String string3 = ("test3");

        Order[] orders = {order1, order2, order3};
        GeneralDAO<Order> orderGeneralDAO = new GeneralDAO<>();
        for (Order el : orders){
            System.out.println(orderGeneralDAO.save(el));
        }

        Long[] longs = {long1, long2, long3};
        GeneralDAO<Long> longGeneralDAO = new GeneralDAO<>();
        for (Long el : longs){
            System.out.println(longGeneralDAO.save(el));
        }

        String[] strings = {string1, string2, string3};
        GeneralDAO<String> stringGeneralDAO = new GeneralDAO<>();
        for (String el : strings){
            System.out.println(stringGeneralDAO.save(el));

        }


    }
}
