package lesson12;

public class UkrainianBankSystem implements BankSystem {

    @Override
    public void withdraw(User user, int amount) {
        //проверить можно ли снять
        //проверить лимит
        //проверить достатчно ли денег
        // снять деньги

        /*int limitOfWithdrawal = user.getBank().getLimitOfWithdrawal();
        if (amount + user.getBank().getCommission(amount)> limitOfWithdrawal){
            printWithdrawalErorMsg(amount, user);
            return;
        }

        if (amount + user.getBank().getCommission(amount) > user.getBalance()){
            printWithdrawalErorMsg(amount, user);
            return;
        }*/

        //if (!checkWithdraw(user, amount, user.getBank().getLimitOfWithdrawal()))
        //return;

        //if (!checkWithdraw(user, amount, user.getBalance()))
        //return;

        //double balanceAfterWithdraw = user.getBalance() - amount - user.getBank().getCommission(amount);
        //user.setBalance(balanceAfterWithdraw);

        if (!checkWithdraw(user, amount))
            return;
        user.setBalance(user.getBalance() - amount - user.getBank().getCommission(amount));
    }

    private boolean checkWithdraw(User user, int amount) {
        return checkWithdrawLimits(user, amount, user.getBank().getLimitOfWithdrawal()) &&
                checkWithdrawLimits(user, amount, user.getBalance());
    }

    private boolean checkWithdrawLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printWithdrawalErorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printWithdrawalErorMsg(int amount, User user) {
        System.err.println("Can't withdraw money " + amount + "from user " + user.toString());
    }

    @Override
    public void fund(User user, int amount) {

        if (user != null) {
            if (!checkFund(user, amount))
                return;
            user.setBalance(user.getBalance() + amount - user.getBank().getCommission(amount));
        }
    }

    private boolean checkFund(User user, int amount) {
        return checkFundLimits(user, amount, user.getBank().getLimitOfFunding()) &&
                checkFundLimits(user, amount, user.getBalance());
    }

    private boolean checkFundLimits(User user, int amount, double limit) {
        if (amount + user.getBank().getCommission(amount) > limit) {
            printFundErorMsg(amount, user);
            return false;
        }
        return true;
    }

    private void printFundErorMsg(int amount, User user) {
        System.err.println("Can't funding money" + amount + "from user" + user.toString());
    }


    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {
        // снимаем деньги fromUser
        // пополняем toUser

        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFund(toUser, amount))
            return;
        if (fromUser != null) {
            if (toUser != null) {
                fromUser.setBalance(fromUser.getBalance() - amount - fromUser.getBank().getCommission(amount));
                toUser.setBalance(toUser.getBalance() + amount - toUser.getBank().getCommission(amount));
            }

        }
    }

    @Override
    public void paySalary(User user) {
        // TODO: 2019-03-10  homeWork;

    }


}
