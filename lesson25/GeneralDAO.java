package lesson25;

import java.util.Arrays;

public class GeneralDAO<T> {


    public <T extends IdEntity> void validate(T t) throws Exception {
        if (t.getId() <= 0)
            throw new Exception("id can't be negative");
    }

    private void print(Order order) {
        System.out.println("order is:" + order.toString());
    }

    public <K> void validate(K k) {
        if (k.equals(100)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(t))
                throw new Exception("Sorry, but the Element is already in the array");
            if (array[i] == null)
                return array[i] = t;
        }
        throw new Exception("Array overflow");
    }

    public T[] getAll() {
        return array;
    }

    @Override
    public String toString() {
        return "GeneralDAO{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}