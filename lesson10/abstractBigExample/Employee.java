package lesson10.abstractBigExample;

public abstract class Employee {

    private String name;
    private int age;
    private int yearsOfExperiance;
    private int salaryPerMonth;
    private BankAccount bankAccount;
    private String curPosition;
    private Company[] companiesWorked = new Company[10];
    private String[] positionsWorker = new String[10];


    abstract void paySalary();

    void changePosition(String newPosition){
        // схоранить текущию позицию в истории
        // поменять позицию
        saveCurPositionToHistory();
        curPosition = newPosition;
    }

    private void saveCurPositionToHistory(){
        int index = 0;
        for (String pos : positionsWorker){
            if (pos == null){
                positionsWorker[index] = curPosition;
                break;
            }
            index++;
        }
    }

    int getBalance(){
        return bankAccount.getBalance();
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public int getSalaryPerMonth() {
        return salaryPerMonth;
    }

    public String getName() {
        return name;
    }
}
