package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;

public class Controller {
    // принимать запросы пользователя и распределять

    private TransactionDAO transactionDAO = new TransactionDAO();


    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {

        return transactionDAO.save(transaction);
    }


    public Transaction[] transactionList(){

        return transactionDAO.transactionList();
    }


    Transaction[] transactionList(String city){
// TODO: 2019-06-11  
        return null;
    }


    Transaction[] transactionList(int amount){
// TODO: 2019-06-11  
        return null;
    }
}
