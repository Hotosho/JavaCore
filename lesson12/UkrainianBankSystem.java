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

        //user.setBalance(user.getBalance() - amount - user.getBank().getCommission(amount));

        if (!checkWithdraw(user, amount))
            return;
        double balanceAfterWithdraw = user.getBalance() - amount - amount * user.getBank().getCommission(amount);
        user.setBalance(balanceAfterWithdraw);

    }


    @Override
    public void fund(User user, int amount) {

        if (!checkFund(user, amount))
            return;
        if (user.getBank().getLimitOfFunding() > amount)
            user.setBalance(user.getBalance() + amount);
    }


    @Override
    public void transferMoney(User fromUser, User toUser, int amount) {

        if (fromUser.getBank().getCurrency() != toUser.getBank().getCurrency())
            return;

        if (!checkWithdraw(fromUser, amount))
            return;
        if (!checkFund(toUser, amount))
            return;

        fromUser.setBalance(fromUser.getBalance() - amount - amount * fromUser.getBank().getCommission(amount));
        toUser.setBalance(toUser.getBalance() + amount);


    }

    @Override
    public void paySalary(User user) {

        if (!checkPaySalary(user))
            return;

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

    private boolean checkFund(User user, int amount) {
        return user.getBank().getLimitOfFunding() > amount;
    }

    private boolean checkPaySalary(User user){
        if (user.getBank().getLimitOfFunding() > user.getSalary())
            user.setBalance(user.getBalance() + user.getSalary());
        return true;
    }
}

