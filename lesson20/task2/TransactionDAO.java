package lesson20.task2;

import lesson20.task2.exception.BadRequestException;
import lesson20.task2.exception.InternalServerException;
import lesson20.task2.exception.LimitExceeded;

import java.util.Calendar;
import java.util.Date;

//dao работа с данными
public class TransactionDAO {
    private Transaction[] transactions = new Transaction[10];
    private Utils utils = new Utils();

    public Transaction save(Transaction transaction) throws BadRequestException, InternalServerException {
        // сума транзакции больше указанного лимита+
        // сума транзакции за день больше днемвнего лимита+
        // кол. транзакций за день больше указаного лимита+
        // если город оплаты (соверщения транзакции)+
        // не хватило места+

        validate(transaction);

        return checkFreePlace(transaction);

    }

    private void validate(Transaction transaction) throws BadRequestException {

        if (transaction == null)
            throw new BadRequestException("Transaction empty. Can't be saved");

        checkCity(transaction);

        if (transaction.getAmount() > utils.getLimitSimpleTransactionAmount())
            throw new LimitExceeded("Transaction limit exceed" + transaction.getId() + ". Can't be saved");

        int sum = 0;
        int count = 0;
        int index = 0;
        for (Transaction tr : getTransactionsPerDay(transaction.getDateCreated())) {
            transactions[index] = tr;
            sum += tr.getAmount();
            count += tr.getAmount();
        }


        if (sum > utils.getLimitTransactionsPerDayAmount()) {
            throw new LimitExceeded("Transaction limit per day amount exceed" + transaction.getId() + ". Can't be saved");
        }


        if (count > utils.getLimitTransactionsPerDayCount()) {
            throw new LimitExceeded("Transaction limit per day count exceed" + transaction.getId() + ". Can't be saved");
        }


    }


    public Transaction[] transactionList() {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null)
                count++;
        }

        Transaction[] returnTransactionList = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null) {
                returnTransactionList[i] = tr;
                i++;
            }
        }
        return returnTransactionList;
    }


    Transaction[] transactionList(String city) {

        int count = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(utils.getCities()))
                count++;

        }

        Transaction[] returnTransactionListCity = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr != null && tr.getCity().equals(utils.getCities()))
                returnTransactionListCity[i] = tr;
            i++;
        }
        return returnTransactionListCity;
    }


    Transaction[] transactionList(int amount) {

        int count = 0;
        for (Transaction tr : transactions){
            if (tr != null && tr.getAmount() == utils.getLimitTransactionsPerDayCount())
                count++;
        }

        Transaction[] returnTransactionListAmount = new Transaction[count];

        int i = 0;
        for (Transaction tr : transactions){
            if (tr != null && tr.getAmount() == utils.getLimitTransactionsPerDayAmount())
                returnTransactionListAmount[i] = tr;
            i++;
        }
        return returnTransactionListAmount;
    }

    private Transaction[] getTransactionsPerDay(Date dateOfCurTransaction) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateOfCurTransaction);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int count = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);

                if (trMonth == month && trDay == day)
                    count++;
            }
        }


        Transaction[] result = new Transaction[count];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                calendar.setTime(transaction.getDateCreated());
                int trMonth = calendar.get(Calendar.MONTH);
                int trDay = calendar.get(Calendar.DAY_OF_MONTH);
                if (trMonth == month && trDay == day) {
                    result[index] = transaction;
                    index++;
                }
            }
        }
        return result;
    }

    private void checkCity(Transaction transaction) throws BadRequestException {
        for (String city : utils.getCities()) {
            if (city != null && city.equals(transaction.getCity()))
                return;

        }
        throw new BadRequestException("This city cannot be a transaction " + transaction.getId());
    }

    private Transaction checkFreePlace(Transaction transaction) throws InternalServerException {

        int i = 0;
        for (Transaction tr : transactions) {
            if (tr == null) {
                transactions[i] = transaction;
                return transactions[i];

            }
            i++;
        }
        throw new InternalServerException("Not free place in array" + transaction.getId());
    }
}
