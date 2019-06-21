package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {

        Transaction transaction1 = new Transaction(1, "Kiev", 4, "las", TransactionType.INCOME, new Date());
        Transaction transaction2 = new Transaction(2, "Odessa", 5, "las2", TransactionType.OUTCOME, new Date());
        Transaction transaction3 = new Transaction(3, "Wroclaw", 15, "wro", TransactionType.INCOME, new Date());
        Transaction transaction4 = new Transaction(4, "Poznan", 20, "poz", TransactionType.OUTCOME, new Date());
        Transaction transaction5 = new Transaction(5, "Kiev", 4, "las3", TransactionType.INCOME, new Date());
        Transaction transaction6 = new Transaction(6, "Odessa", 6, "las4", TransactionType.OUTCOME, new Date());
        Transaction transaction7 = new Transaction(7, "Kiev", 5, "las5", TransactionType.INCOME, new Date());
        Transaction transaction8 = new Transaction(8, "Odessa", 3, "las6", TransactionType.OUTCOME, new Date());
        Transaction transaction9 = new Transaction(9, "Kiev", 3, "las7", TransactionType.INCOME, new Date());
        Transaction transaction10 = new Transaction(10, "Odessa", 2, "las8", TransactionType.OUTCOME, new Date());

        Transaction[] transactionsArray = {transaction1, transaction2, transaction3, transaction4, transaction5, transaction6,
        transaction7, transaction8, transaction9, transaction10};

        Controller controller = new Controller();
        
        controller.transactionList();



        System.out.println(Arrays.toString(controller.transactionList()));
        System.out.println(Arrays.toString(controller.transactionList("Kiev")));
        System.out.println(Arrays.toString(controller.transactionList(5)));

        for (Transaction tr : transactionsArray){
            try{
                controller.save(tr);
            } catch (BadRequestException i1){
                System.err.println(i1.getMessage());
            } catch (InternalServerException i2){
                System.err.println(i2.getMessage());
            }
        }

        System.out.println(Arrays.toString(controller.transactionList("Wroclaw")));
        System.out.println(Arrays.toString(controller.transactionList(100500)));




    }
}
