package lessonTest;

import lessonTest.exceptions.BadRequestException;
import lessonTest.exceptions.InternalServerException;
import lessonTest.exceptions.LimitExceeded;

public class Controller {
    private TransactionDAO transactionDAO = new TransactionDAO();

    public Transaction save (Transaction transaction) throws BadRequestException, InternalServerException {
        return transactionDAO.save(transaction);
    }

    public Transaction[] transactionList (){
        return transactionDAO.transactionList();
    }

    public Transaction[] transactionList (String city){
        return transactionDAO.transactionList(city);
    }


    public Transaction[] transactionList (int amount){
        return transactionDAO.transactionList(amount);
    }


}