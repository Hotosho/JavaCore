package lesson10.abstractBigExample;

public class ManagerEmployee extends Employee {

    @Override
    void paySalary() {
        int newBalance = getBankAccount().getBalance() + getSalaryPerMonth() + 1000;
        newBalance += newBalance * 0.25;
        getBankAccount().setBalance(newBalance);
    }
}
