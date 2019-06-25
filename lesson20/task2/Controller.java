package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

public class Controller {
    // принимать запросы пользователя и распределять

    private TransactionDAO transactionDAO = new TransactionDAO();


    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {

        return transactionDAO.save(transaction);
    }


    public Transaction[] transactionList(){

        return transactionDAO.transactionList();
    }


    public Transaction[] transactionList(String city){

        return transactionDAO.transactionList(city);
    }


    Transaction[] transactionList(int amount){

        return transactionDAO.transactionList(amount);
    }
}
